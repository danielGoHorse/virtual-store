package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.dto.UsuarioClienteRequestDTO;
import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.repository.PermissaoRepository;
import com.dev.virtualstorebackend.repository.UsuarioClienteRepository;
import com.dev.virtualstorebackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Usuario registrar(UsuarioClienteRequestDTO usuarioClienteRequestDTO) {
        Usuario usuario = new UsuarioClienteRequestDTO().converter(usuarioClienteRequestDTO);
        usuario.setDataCriacao(new Date());
        Usuario newObject = usuarioClienteRepository.saveAndFlush(usuario);
        permissaoPessoaService.vincularUsuarioPermissaoUsuario(newObject);
        emailService.enviarEmailTexto(newObject.getEmail(), "Novo Cadastro de Cliente","Registro realizado com sucesso!!!");
        return newObject;
    }

}
