package com.georiesgos.soa.dominios.territorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

    Optional<Distrito> findByUbigeo(String ubigeo);

}