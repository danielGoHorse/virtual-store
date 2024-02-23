package com.dev.virtualstorebackend.repository;

import com.dev.virtualstorebackend.entity.Cidade;
import com.dev.virtualstorebackend.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
