package com.dev.virtualstorebackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;

    private String codRecuperacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCod;

    private String senha;
    private String email;
    private String endereco;
    private String cep;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    @JsonManagedReference
    private List<PermissaoPessoa> permissaoPessoas;

    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for(PermissaoPessoa p:pp){
            p.setUsuario(this);
        }
        this.permissaoPessoas = pp;
    }
}