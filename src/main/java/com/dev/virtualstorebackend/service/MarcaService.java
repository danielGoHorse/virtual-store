package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Marca;
import com.dev.virtualstorebackend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca create(Marca object) {
        object.setDataCriacao(new Date());
        Marca novaMarca = marcaRepository.saveAndFlush(object);
        return novaMarca;
    }

    public Marca edit(Marca object) {
        object.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(object);
    }

    public Marca delete(Long id) {
        Marca object = marcaRepository.findById(id).get();
        marcaRepository.delete(object);
        return object;
    }
}
