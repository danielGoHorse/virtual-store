package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.PermissaoPessoa;
import com.dev.virtualstorebackend.service.PermissaoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissaoPessoa")
public class PermissaoPessoaController {
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

//    @GetMapping("/")
//    public List<PermissaoPessoa> buscarTodos(PermissaoPessoa permissaoPessoa) {
//        return permissaoPessoaService.findAll();
//    }
//
//    @PostMapping("/")
//    public PermissaoPessoa inserir(@RequestBody  PermissaoPessoa permissaoPessoa) {
//
//        return permissaoPessoaService.create(permissaoPessoa);
//    }
//
//    @PutMapping("/")
//    public PermissaoPessoa alterar(@RequestBody PermissaoPessoa permissaoPessoa) {
//
//        return permissaoPessoaService.edit(permissaoPessoa);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
//
//        permissaoPessoaService.delete(id);
//        return ResponseEntity.ok().build();
//    }
}
