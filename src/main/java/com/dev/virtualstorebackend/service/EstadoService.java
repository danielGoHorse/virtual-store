package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Estado;
import com.dev.virtualstorebackend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado create(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado novoEstado = estadoRepository.saveAndFlush(estado);
        return novoEstado;
    }

    public Estado edit(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public Estado delete(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
        return estado;
    }
}
