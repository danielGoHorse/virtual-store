package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Cidade;
import com.dev.virtualstorebackend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos(Cidade cidade) {
        return cidadeService.findAll();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody  Cidade cidade) {

        return cidadeService.create(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade) {

        return cidadeService.edit(cidade);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        cidadeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
