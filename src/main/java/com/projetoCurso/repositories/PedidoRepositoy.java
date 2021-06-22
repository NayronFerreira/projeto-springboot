package com.projetoCurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoCurso.entidades.Pedido;

public interface PedidoRepositoy extends JpaRepository<Pedido, Long>{

}
