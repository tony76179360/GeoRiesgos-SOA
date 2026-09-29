package com.georiesgos.soa.dominios.territorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Optional<Departamento> findByUbigeo(String ubigeo);

    Optional<Departamento> findByNombre(String nombre);

    Optional<Departamento> findByNombreAndUbigeo(String nombre, String ubigeo);
}
