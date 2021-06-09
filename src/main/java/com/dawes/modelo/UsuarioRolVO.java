package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuariorol")
public class UsuarioRolVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idac;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UsuarioVO usuario;
	@ManyToOne
	@JoinColumn(name = "idrol")
	private RolVO rol;
	
}
