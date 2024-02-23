package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> buscarTodos(Usuario usuario) {
        return usuarioService.findAll();
    }

    @PostMapping("/")
    public Usuario inserir(@RequestBody  Usuario usuario) {

        return usuarioService.create(usuario);
    }

    @PutMapping("/")
    public Usuario alterar(@RequestBody Usuario usuario) {

        return usuarioService.edit(usuario);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
