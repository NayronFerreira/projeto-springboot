package com.projetoCurso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.repositories.UsuarioRepositoy;
import com.projetoCurso.services.exceptions.DataBaseException;
import com.projetoCurso.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositoy userRepository;

	public List<Usuario> findAlll() {
		return userRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario inserir(Usuario usuario) {
		return userRepository.save(usuario);
	}

	public void deletar(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException di) {
			throw new DataBaseException(di.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {
		Usuario entity = userRepository.getOne(id);
		atualizarDados(entity, obj);
		return userRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	public void atualizarDados(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}
