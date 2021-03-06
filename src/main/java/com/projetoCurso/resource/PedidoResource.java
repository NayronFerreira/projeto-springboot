package com.projetoCurso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCurso.entidades.Pedido;
import com.projetoCurso.services.PedidoService;



@RestController
@RequestMapping(value ="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity <List <Pedido>>findAll() {
		List <Pedido> lista = pedidoService.findAlll();
		return ResponseEntity.ok().body(lista);
	}
	 
	@GetMapping (value ="/{id}")
	public ResponseEntity<Pedido> findById (@PathVariable Long id){
		Pedido user = pedidoService.findById(id);
		return ResponseEntity.ok().body(user);
	} 

}
