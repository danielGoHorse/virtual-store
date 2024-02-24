package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.Imagem;
import com.dev.virtualstorebackend.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/api/imagem")
public class ImagemController {
    @Autowired
    private ImagemService imagemService;

    @GetMapping("/")
    public List<Imagem> buscarTodos(Imagem imagem) {
        return imagemService.findAll();
    }

    @PostMapping("/")
    public Imagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file) {

        return imagemService.create(idProduto, file);
    }

    @PutMapping("/")
    public Imagem alterar(@RequestBody Imagem imagem) {
        return imagemService.edit(imagem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        imagemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
