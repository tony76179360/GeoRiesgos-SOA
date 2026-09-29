package com.georiesgos.soa.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Crea el SPATIAL INDEX sobre {@code distrito.geometria}.
 *
 * <p>JPA no tiene forma de declarar un índice espacial ({@code @Index} genera un
 * BTREE normal, que MySQL rechaza sobre columnas GEOMETRY), así que el DDL se emite
 * aquí, una vez que Hibernate ya creó la tabla.
 *
 * <p>Es idempotente: consulta {@code information_schema} antes de crear, porque
 * MySQL no admite {@code CREATE INDEX IF NOT EXISTS}.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class IndiceEspacialInitializer implements ApplicationRunner {

    private static final String TABLA = "distrito";
    private static final String COLUMNA = "geometria";
    private static final String INDICE = "idx_distrito_geometria";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) {
        if (existeIndice()) {
            log.debug("SPATIAL INDEX {} ya existe, no se recrea", INDICE);
            return;
        }
        jdbcTemplate.execute(
                "CREATE SPATIAL INDEX %s ON %s (%s)".formatted(INDICE, TABLA, COLUMNA));
        log.info("SPATIAL INDEX {} creado sobre {}.{}", INDICE, TABLA, COLUMNA);
    }

    private boolean existeIndice() {
        Integer coincidencias = jdbcTemplate.queryForObject("""
                SELECT COUNT(*) FROM information_schema.STATISTICS
                WHERE TABLE_SCHEMA = DATABASE()
                  AND TABLE_NAME = ?
                  AND INDEX_NAME = ?
                """, Integer.class, TABLA, INDICE);
        return coincidencias != null && coincidencias > 0;
    }

}
