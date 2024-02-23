package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Produto;
import com.dev.virtualstorebackend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodos(Produto produto) {
        return produtoService.findAll();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody  Produto produto) {

        return produtoService.create(produto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto) {

        return produtoService.edit(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
