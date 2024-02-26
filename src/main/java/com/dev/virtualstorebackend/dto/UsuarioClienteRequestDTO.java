package com.dev.virtualstorebackend.dto;

import com.dev.virtualstorebackend.entity.Cidade;
import com.dev.virtualstorebackend.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;

import java.util.Date;

@Data
public class UsuarioClienteRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;


    public Usuario converter(UsuarioClienteRequestDTO usuarioClienteRequestDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioClienteRequestDTO, usuario);
        return usuario;
    }


}