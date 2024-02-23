package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Estado;
import com.dev.virtualstorebackend.service.EstadoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> buscarTodos(Estado estado) {
    return estadoService.findAll();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody  Estado estado) {

        return estadoService.create(estado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {

        return estadoService.edit(estado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

         estadoService.delete(id);
         return ResponseEntity.ok().build();
    }


}
