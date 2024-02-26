package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.service.UsuarioGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario-gerenciamento")
public class UsuarioGerenciamentoController {
    @Autowired
    private UsuarioGerenciamentoService service;

    @PostMapping("/")
    public String recuperarCodigo(@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        return service.solicitarCod(email);
    }

}
