package com.dev.virtualstorebackend.repository;

import com.dev.virtualstorebackend.entity.CarrinhoCompra;
import com.dev.virtualstorebackend.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {

}
