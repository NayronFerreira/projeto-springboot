package com.projetoCurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Produto;
import com.projetoCurso.repositories.ProdutoRepositoy;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepositoy categoriaRepository;
	
	public List <Produto> findAlll () {
		return categoriaRepository.findAll();
	}
	public Produto findById (Long id) {
		 Optional<Produto> obj = categoriaRepository.findById(id);
		 return obj.get();
	}
}
