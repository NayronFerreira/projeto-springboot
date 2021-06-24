package com.projetoCurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Pedido;
import com.projetoCurso.repositories.PedidoRepositoy;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepositoy userRepository;
	
	public List <Pedido> findAlll () {
		return userRepository.findAll();
	}
	public Pedido findById (Long id) {
		 Optional<Pedido> obj = userRepository.findById(id);
		 return obj.get();
	}
}
