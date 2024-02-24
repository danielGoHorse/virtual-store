package com.dev.virtualstorebackend.controller;

import com.dev.virtualstorebackend.entity.CarrinhoCompra;
import com.dev.virtualstorebackend.service.CarrinhoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhoCompra")
public class CarrinhoCompraController {
    @Autowired
    private CarrinhoCompraService carrinhoCompraService;

    @GetMapping("/")
    public List<CarrinhoCompra> buscarTodos(CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.findAll();
    }

    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody  CarrinhoCompra carrinhoCompra) {

        return carrinhoCompraService.create(carrinhoCompra);
    }

    @PutMapping("/")
    public CarrinhoCompra alterar(@RequestBody CarrinhoCompra carrinhoCompra) {

        return carrinhoCompraService.edit(carrinhoCompra);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

        carrinhoCompraService.delete(id);
        return ResponseEntity.ok().build();
    }
}
