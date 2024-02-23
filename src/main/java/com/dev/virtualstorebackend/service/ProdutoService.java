package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Produto;
import com.dev.virtualstorebackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto create(Produto object) {
        object.setDataCriacao(new Date());
        Produto novaProduto = produtoRepository.saveAndFlush(object);
        return novaProduto;
    }

    public Produto edit(Produto object) {
        object.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(object);
    }

    public Produto delete(Long id) {
        Produto object = produtoRepository.findById(id).get();
        produtoRepository.delete(object);
        return object;
    }
}
