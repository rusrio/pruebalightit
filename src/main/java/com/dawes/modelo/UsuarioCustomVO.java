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
@Table(name="usuariocustom")
public class UsuarioCustomVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuariocustom;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO usuario;
	@ManyToOne
	@JoinColumn(name = "idcustom")
	private CustomVO custom;
	
	private Date fechapublicacion;
}
