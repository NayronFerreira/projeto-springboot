package com.projetoCurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Categoria;
import com.projetoCurso.repositories.CategoriaRepositoy;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositoy categoriaRepository;
	
	public List <Categoria> findAlll () {
		return categoriaRepository.findAll();
	}
	public Categoria findById (Long id) {
		 Optional<Categoria> obj = categoriaRepository.findById(id);
		 return obj.get();
	}
}
