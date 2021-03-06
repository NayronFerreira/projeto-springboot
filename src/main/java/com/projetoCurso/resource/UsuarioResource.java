package com.projetoCurso.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.services.UsuarioService;

@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	@PostMapping
	public ResponseEntity<Usuario> inserir (@RequestBody Usuario usuario){
		usuarioService.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	@DeleteMapping (value ="/{id}")
	public ResponseEntity<Void> deletar (@PathVariable Long id){
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping (value ="/{id}")
	public ResponseEntity<Usuario> atualizar (@PathVariable Long id,@RequestBody Usuario usuario ){
		usuario= usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}

}
