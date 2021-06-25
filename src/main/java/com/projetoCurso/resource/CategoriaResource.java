package com.projetoCurso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCurso.entidades.Categoria;
import com.projetoCurso.services.CategoriaService;



@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity <List <Categoria>>findAll() {
		List <Categoria> lista = categoriaService.findAlll();
		return ResponseEntity.ok().body(lista);
	}
	 
	@GetMapping (value ="/{id}")
	public ResponseEntity<Categoria> findById (@PathVariable Long id){
		Categoria user = categoriaService.findById(id);
		return ResponseEntity.ok().body(user);
	} 

}
