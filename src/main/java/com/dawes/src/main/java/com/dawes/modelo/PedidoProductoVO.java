package com.dawes.modelo;

import java.time.LocalDate;

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
@Table(name = "pedidoproducto")
public class PedidoProductoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpedidoproducto;
	@ManyToOne
	@JoinColumn(name = "idpedido")
	private PedidoVO pedido;
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private ProductoVO producto;
	
}
