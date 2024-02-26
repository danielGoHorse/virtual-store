package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.dto.UsuarioClienteRequestDTO;
import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.repository.UsuarioClienteRepository;
import com.dev.virtualstorebackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UsuarioGerenciamentoService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private EmailService emailService;

    public String solicitarCod(String email) {
    Usuario usuario = usuarioRepository.findByEmail(email);
    usuario.setCodRecuperacao(getCodRecuoeracaoSenha(usuario.getId()));
    usuario.setDataEnvioCod(new Date());
    usuarioRepository.saveAndFlush(usuario);
    emailService.enviarEmailTexto(usuario.getEmail(), "Código de Recuperação", "Seu código de recuperação de senha é: "+usuario.getCodRecuperacao());
    return "Código Enviado!";
    }

    private String getCodRecuoeracaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;
    }

}
