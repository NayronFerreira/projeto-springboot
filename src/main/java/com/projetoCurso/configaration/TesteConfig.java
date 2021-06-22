package com.projetoCurso.configaration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoCurso.entidades.Pedido;
import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.repositories.PedidoRepositoy;
import com.projetoCurso.repositories.UsuarioRepositoy;

@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepositoy urepository;
	@Autowired
	private PedidoRepositoy pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Anna May", "annamay@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Nayron Ferreira", "nayronferreira@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2021-10-18T10:01:02Z"), u1);
		Pedido p2 = new Pedido(null, Instant.parse("2021-10-18T11:01:02Z"), u1);
		Pedido p3 = new Pedido(null, Instant.parse("2021-10-18T12:01:02Z"), u1);
		
		
		urepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
