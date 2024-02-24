package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.CarrinhoCompraProduto;
import com.dev.virtualstorebackend.repository.CarrinhoCompraProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarrinhoCompraProdutoService {

    @Autowired
    private CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;

    public List<CarrinhoCompraProduto> findAll() {
        return carrinhoCompraProdutoRepository.findAll();
    }

    public CarrinhoCompraProduto create(CarrinhoCompraProduto object) {
        object.setDataCriacao(new Date());
        CarrinhoCompraProduto novaCarrinhoCompraProduto = carrinhoCompraProdutoRepository.saveAndFlush(object);
        return novaCarrinhoCompraProduto;
    }

    public CarrinhoCompraProduto edit(CarrinhoCompraProduto object) {
        object.setDataAtualizacao(new Date());
        return carrinhoCompraProdutoRepository.saveAndFlush(object);
    }

    public CarrinhoCompraProduto delete(Long id) {
        CarrinhoCompraProduto object = carrinhoCompraProdutoRepository.findById(id).get();
        carrinhoCompraProdutoRepository.delete(object);
        return object;
    }
}
