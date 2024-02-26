package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Permissao;
import com.dev.virtualstorebackend.entity.PermissaoPessoa;
import com.dev.virtualstorebackend.entity.Usuario;
import com.dev.virtualstorebackend.repository.PermissaoPessoaRepository;
import com.dev.virtualstorebackend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;


    public void vincularUsuarioPermissaoUsuario(Usuario usuario){
        List<Permissao> listPermissao = permissaoRepository.findByNome("cliente");
        if(listPermissao.size()>0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setUsuario(usuario);
            permissaoPessoa.setPermissao(listPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    };

}
