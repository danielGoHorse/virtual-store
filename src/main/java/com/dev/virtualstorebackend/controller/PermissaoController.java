package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Permissao;
import com.dev.virtualstorebackend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos(Permissao permissao) {
        return permissaoService.findAll();
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody  Permissao permissao) {

        return permissaoService.create(permissao);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao permissao) {

        return permissaoService.edit(permissao);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        permissaoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
