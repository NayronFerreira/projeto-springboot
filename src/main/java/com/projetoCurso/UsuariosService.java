package com.projetoCurso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.repositories.UsuariosRepositoy;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuariosRepositoy userRepository;
	
	public List <Usuario> findAlll () {
		return userRepository.findAll();
	}
	public Usuario findById (Long id) {
		 Optional<Usuario> obj = userRepository.findById(id);
		 return obj.get();
	}
}
