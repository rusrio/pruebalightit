package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "roles")
public class RolVO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idrol;
private String nombre;

@OneToMany(mappedBy="rol",cascade= {CascadeType.ALL})
private List<UsuarioRolVO> roles;

}
