package com.dev.virtualstorebackend.repository;

import com.dev.virtualstorebackend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
