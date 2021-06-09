package com.dawes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuariopedido")
public class UsuarioPedidoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuariopedido;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO usuario;
	@ManyToOne
	@JoinColumn(name = "idpedido")
	private PedidoVO pedido;
	private Date fechaPedido;
}
