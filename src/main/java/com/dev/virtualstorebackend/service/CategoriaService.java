package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Categoria;
import com.dev.virtualstorebackend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria object) {
        object.setDataCriacao(new Date());
        Categoria novaCategoria = categoriaRepository.saveAndFlush(object);
        return novaCategoria;
    }

    public Categoria edit(Categoria object) {
        object.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(object);
    }

    public Categoria delete(Long id) {
        Categoria object = categoriaRepository.findById(id).get();
        categoriaRepository.delete(object);
        return object;
    }
}
