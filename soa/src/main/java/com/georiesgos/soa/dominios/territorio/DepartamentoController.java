package com.georiesgos.soa.dominios.territorio;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {
    private final DepartamentoService ds;

    // get post delete
    // crear
    @PostMapping
    public ResponseEntity<Departamento> crobjeto(@RequestBody Departamento dp) {
        Departamento resultado = ds.crear(dp);
        return ResponseEntity.ok(resultado);
    }

    // leer todos los departarmentos
    @GetMapping
    public ResponseEntity<List<Departamento>> todos() {
        List<Departamento> lista = ds.listDepartamento();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Departamento> ubi(@PathVariable String nombre) {
        Departamento encontrado = ds.buscar(nombre);
        return ResponseEntity.ok(encontrado);
    }

    @GetMapping("/{nombre}/{ubigeo}")
    public ResponseEntity<Departamento> rt(@PathVariable String nombre, @PathVariable String ubigeo) {
        Departamento encontrado = ds.gh(nombre, ubigeo);
        return ResponseEntity.ok(encontrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {
        ds.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
