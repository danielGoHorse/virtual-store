package com.dev.virtualstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="carrinho_compra")
@Data
public class CarrinhoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String situacao;
    private String observacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
