package com.projetoCurso.configaration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.repositories.UsuariosRepositoy;

@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private UsuariosRepositoy urepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Anna May", "annamay@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Nayron Ferreira", "nayronferreira@gmail.com", "977777777", "123456");
		
		urepository.saveAll(Arrays.asList(u1,u2));
	}

}
