package com.projetoCurso.entidades.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCurso.entidades.Usuarios;

@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuarios> findAll() {
		Usuarios usuario = new Usuarios(1L, "Anna May","AnnaMay@gmail.com", "(11)99999-1111", "naotemsenha");
		return ResponseEntity.ok().body(usuario);
	}

}
