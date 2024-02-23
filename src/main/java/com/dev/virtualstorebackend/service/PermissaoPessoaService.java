package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.PermissaoPessoa;
import com.dev.virtualstorebackend.repository.PermissaoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    public List<PermissaoPessoa> findAll() {
        return permissaoPessoaRepository.findAll();
    }

    public PermissaoPessoa create(PermissaoPessoa object) {
        object.setDataCriacao(new Date());
        PermissaoPessoa novaPermissaoPessoa = permissaoPessoaRepository.saveAndFlush(object);
        return novaPermissaoPessoa;
    }

    public PermissaoPessoa edit(PermissaoPessoa object) {
        object.setDataAtualizacao(new Date());
        return permissaoPessoaRepository.saveAndFlush(object);
    }

    public PermissaoPessoa delete(Long id) {
        PermissaoPessoa object = permissaoPessoaRepository.findById(id).get();
        permissaoPessoaRepository.delete(object);
        return object;
    }
}
