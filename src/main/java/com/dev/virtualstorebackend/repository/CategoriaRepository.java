package com.dev.virtualstorebackend.repository;

import com.dev.virtualstorebackend.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
