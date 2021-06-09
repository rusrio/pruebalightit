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
@Table(name = "usuarioproducto")
public class UsuarioProductoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuarioproducto;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO usuario;
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private ProductoVO producto;
	
	private Date fechapublicacion;
}
