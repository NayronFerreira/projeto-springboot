package com.projetoCurso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.projetoCurso.entidades.enuns.PedidoStatus;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer pedidoStatus;

	private Instant momento;
	

	@ManyToOne
	@JoinColumn (name="cliente_id")
	private Usuario cliente;
	@OneToMany (mappedBy = "id.pedido")
	private Set <ItemPedido> itens = new HashSet<>(); 
	
	@OneToOne (mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {

	}

	public Pedido(Long id, Instant momento,PedidoStatus pedidoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		this.pedidoStatus = pedidoStatus.getCodigo();
		this.cliente = cliente;
	}
	public Pagamento getPagamento () {
		return pagamento;
	}
	public void setPagamento (Pagamento pagamento) {
		this.pagamento=pagamento;
	}

	public Long getId() {
		return id;
	}
	public Set <ItemPedido> getItens (){
		return itens;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOff(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		this.pedidoStatus = pedidoStatus.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
