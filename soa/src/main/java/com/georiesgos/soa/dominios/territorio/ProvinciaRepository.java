package com.georiesgos.soa.dominios.territorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    Optional<Provincia> findByUbigeo(String ubigeo);

    List<Provincia> findByDepartamentoUbigeo(String departamentoUbigeo);

}
