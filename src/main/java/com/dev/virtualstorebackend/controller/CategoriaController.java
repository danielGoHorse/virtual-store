package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Categoria;
import com.dev.virtualstorebackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> buscarTodos(Categoria categoria) {
        return categoriaService.findAll();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody  Categoria categoria) {

        return categoriaService.create(categoria);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria) {

        return categoriaService.edit(categoria);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
