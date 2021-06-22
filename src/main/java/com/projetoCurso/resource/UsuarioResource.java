package com.projetoCurso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCurso.UsuariosService;
import com.projetoCurso.entidades.Usuario;



@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuariosService usuarioService;
	
	@GetMapping
	public ResponseEntity <List <Usuario>>findAll() {
		List <Usuario> lista = usuarioService.findAlll();
		return ResponseEntity.ok().body(lista);
	}
	 
	@GetMapping (value ="/{id}")
	public ResponseEntity<Usuario> findById (@PathVariable Long id){
		Usuario user = usuarioService.findById(id);
		return ResponseEntity.ok().body(user);
	} 

}
