package com.dev.virtualstorebackend.repository;

import com.dev.virtualstorebackend.entity.CarrinhoCompra;
import com.dev.virtualstorebackend.entity.CarrinhoCompraProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraProdutoRepository extends JpaRepository<CarrinhoCompraProduto, Long> {

}
