package com.projetoCurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoCurso.entidades.Produto;

public interface ProdutoRepositoy extends JpaRepository<Produto, Long>{

}
