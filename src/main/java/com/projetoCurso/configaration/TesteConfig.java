package com.projetoCurso.configaration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoCurso.entidades.Categoria;
import com.projetoCurso.entidades.Pedido;
import com.projetoCurso.entidades.Produto;
import com.projetoCurso.entidades.Usuario;
import com.projetoCurso.entidades.enuns.PedidoStatus;
import com.projetoCurso.repositories.CategoriaRepositoy;
import com.projetoCurso.repositories.PedidoRepositoy;
import com.projetoCurso.repositories.ProdutoRepositoy;
import com.projetoCurso.repositories.UsuarioRepositoy;

@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepositoy urepository;
	@Autowired
	private PedidoRepositoy pedidoRepository;
	@Autowired
	private CategoriaRepositoy categoriaRepository;
	@Autowired
	private ProdutoRepositoy produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto prod1 = new Produto(null, "Playstation V", "Console com 2 controles 1T", 5.000, "");
		Produto prod2 = new Produto(null, "Iphone XV", "10 câmeras, 2T GB", 25.000, "");
		Produto prod3 = new Produto(null, "O livro de Eli", "Eae, o ator é cego ou não?", 50.00, "");
		Produto prod4 = new Produto(null, "A arte de Argumentar", "Aprenda a argumentar tudo e nunca perder um debate!", 5.000, "");
		Produto prod5 = new Produto(null, "Notebook Gamer", "Processador i7 10g, 2T GB, Placa Video 3 GB", 6.000, "");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
		prod1.getCategoria().add(cat3);
		prod1.getCategoria().add(cat1);
		prod2.getCategoria().add(cat3);
		prod2.getCategoria().add(cat1);
		prod3.getCategoria().add(cat2);
		prod4.getCategoria().add(cat2);
		prod5.getCategoria().add(cat3);
		prod5.getCategoria().add(cat1);
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
		Usuario u1 = new Usuario(null, "Anna May", "annamay@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Nayron Ferreira", "nayronferreira@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2021-10-18T10:01:02Z"),PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2021-10-18T11:01:02Z"),PedidoStatus.AGUARDANDO_PAGAMENTO,u1);
		Pedido p3 = new Pedido(null, Instant.parse("2021-10-18T12:01:02Z"),PedidoStatus.CANCELADO, u1);
		
		
		urepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
