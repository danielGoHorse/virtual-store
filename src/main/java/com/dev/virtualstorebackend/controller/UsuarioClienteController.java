package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.dto.UsuarioClienteRequestDTO;
import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.service.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class UsuarioClienteController {
    @Autowired
    private UsuarioClienteService usuarioClienteService;

      @PostMapping("/")
    public Usuario inserir(@RequestBody UsuarioClienteRequestDTO usuarioClienteRequestDTO) {
        return usuarioClienteService.registrar(usuarioClienteRequestDTO);
    }

}
