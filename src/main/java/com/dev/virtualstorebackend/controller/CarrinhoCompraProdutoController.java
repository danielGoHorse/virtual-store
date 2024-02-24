package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.CarrinhoCompraProduto;
import com.dev.virtualstorebackend.service.CarrinhoCompraProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhoCompraProduto")
public class CarrinhoCompraProdutoController {
    @Autowired
    private CarrinhoCompraProdutoService carrinhoCompraProdutoService;

    @GetMapping("/")
    public List<CarrinhoCompraProduto> buscarTodos(CarrinhoCompraProduto carrinhoCompraProduto) {
        return carrinhoCompraProdutoService.findAll();
    }

    @PostMapping("/")
    public CarrinhoCompraProduto inserir(@RequestBody  CarrinhoCompraProduto carrinhoCompraProduto) {

        return carrinhoCompraProdutoService.create(carrinhoCompraProduto);
    }

    @PutMapping("/")
    public CarrinhoCompraProduto alterar(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto) {

        return carrinhoCompraProdutoService.edit(carrinhoCompraProduto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        carrinhoCompraProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
