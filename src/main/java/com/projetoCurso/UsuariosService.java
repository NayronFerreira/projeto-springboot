package com.projetoCurso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidade.repositories.UsuariosRepositoy;
import com.projetoCurso.entidades.Usuarios;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuariosRepositoy userRepository;
	
	public List <Usuarios> findAlll () {
		return userRepository.findAll();
	}
	public Usuarios findById (Long id) {
		 Optional<Usuarios> obj = userRepository.findById(id);
		 return obj.get();
	}
}
