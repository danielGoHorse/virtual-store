package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Cidade;
import com.dev.virtualstorebackend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade create(Cidade object) {
        object.setDataCriacao(new Date());
        Cidade novaCidade = cidadeRepository.saveAndFlush(object);
        return novaCidade;
    }

    public Cidade edit(Cidade object) {
        object.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(object);
    }

    public Cidade delete(Long id) {
        Cidade object = cidadeRepository.findById(id).get();
        cidadeRepository.delete(object);
        return object;
    }
}
