package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Permissao;
import com.dev.virtualstorebackend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }

    public Permissao create(Permissao object) {
        object.setDataCriacao(new Date());
        Permissao novaPermissao = permissaoRepository.saveAndFlush(object);
        return novaPermissao;
    }

    public Permissao edit(Permissao object) {
        object.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(object);
    }

    public Permissao delete(Long id) {
        Permissao object = permissaoRepository.findById(id).get();
        permissaoRepository.delete(object);
        return object;
    }
}
