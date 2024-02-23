package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Marca;
import com.dev.virtualstorebackend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarTodos(Marca marca) {
        return marcaService.findAll();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody  Marca marca) {

        return marcaService.create(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {

        return marcaService.edit(marca);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        marcaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
