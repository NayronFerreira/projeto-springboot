package com.projetoCurso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCurso.entidades.Produto;
import com.projetoCurso.services.ProdutoService;



@RestController
@RequestMapping(value ="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity <List <Produto>>findAll() {
		List <Produto> lista = produtoService.findAlll();
		return ResponseEntity.ok().body(lista);
	}
	 
	@GetMapping (value ="/{id}")
	public ResponseEntity<Produto> findById (@PathVariable Long id){
		Produto user = produtoService.findById(id);
		return ResponseEntity.ok().body(user);
	} 

}
