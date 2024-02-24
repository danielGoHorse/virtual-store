package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.CarrinhoCompra;
import com.dev.virtualstorebackend.repository.CarrinhoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarrinhoCompraService {

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> findAll() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra create(CarrinhoCompra object) {
        object.setDataCriacao(new Date());
        CarrinhoCompra novaCarrinhoCompra = carrinhoCompraRepository.saveAndFlush(object);
        return novaCarrinhoCompra;
    }

    public CarrinhoCompra edit(CarrinhoCompra object) {
        object.setDataAtualizacao(new Date());
        return carrinhoCompraRepository.saveAndFlush(object);
    }

    public CarrinhoCompra delete(Long id) {
        CarrinhoCompra object = carrinhoCompraRepository.findById(id).get();
        carrinhoCompraRepository.delete(object);
        return object;
    }
}
