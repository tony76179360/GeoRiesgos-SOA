package com.georiesgos.soa.dominios.territorio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    private final DepartamentoRepository dr;

    // CRUD: crear, leer, actualizar y eliminar

    // crear
    public Departamento crear(Departamento d) {
        return dr.save(d);
    }

    // leer todos
    public List<Departamento> listDepartamento() {
        return dr.findAll();
    }

    // buscar x nombre
    public Departamento buscar(String nombre) {
        Optional<Departamento> cajita = dr.findByNombre(nombre);
        if (cajita.isEmpty()) {
            return new Departamento();

        }
        return cajita.get();
    }

    public Departamento gh(String nombre, String ubigeo) {
        Optional<Departamento> cajita = dr.findByNombreAndUbigeo(nombre, ubigeo);
        if (cajita.isEmpty()) {
            return new Departamento();

        }
        return cajita.get();
    }

    // eliminar id
    public void eliminar(Long id) {
        dr.deleteById(id);
    }
}
