package com.projetoCurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoCurso.entidades.Usuario;

public interface UsuarioRepositoy extends JpaRepository<Usuario, Long>{

}
