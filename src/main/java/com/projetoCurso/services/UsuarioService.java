package com.projetoCurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.repositories.UsuarioRepositoy;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositoy userRepository;

	public List <Usuario> findAlll () {
		return userRepository.findAll();
	}
	public Usuario findById (Long id) {
		 Optional<Usuario> obj = userRepository.findById(id);
		 return obj.get();
	}
	public Usuario inserir (Usuario usuario) {
		return userRepository.save(usuario);
	}
	public void deletar (Long id) {
		userRepository.deleteById(id); 		
	}
}
