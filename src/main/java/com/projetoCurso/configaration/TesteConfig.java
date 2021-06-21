package com.projetoCurso.configaration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoCurso.entidade.repositories.UsuariosRepositoy;
import com.projetoCurso.entidades.Usuarios;

@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private UsuariosRepositoy urepository;

	@Override
	public void run(String... args) throws Exception {
		Usuarios u1 = new Usuarios(null, "Anna May", "annamay@gmail.com", "988888888", "123456");
		Usuarios u2 = new Usuarios(null, "Nayron Ferreira", "nayronferreira@gmail.com", "977777777", "123456");
		
		urepository.saveAll(Arrays.asList(u1,u2));
	}

}
