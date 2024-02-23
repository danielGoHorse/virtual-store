package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(Usuario object) {
        object.setDataCriacao(new Date());
        Usuario novaUsuario = usuarioRepository.saveAndFlush(object);
        return novaUsuario;
    }

    public Usuario edit(Usuario object) {
        object.setDataAtualizacao(new Date());
        return usuarioRepository.saveAndFlush(object);
    }

    public Usuario delete(Long id) {
        Usuario object = usuarioRepository.findById(id).get();
        usuarioRepository.delete(object);
        return object;
    }
}
