package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="custom")
public class CustomVO {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idcustom;
	
@NotNull
@Column(unique=true)
private String nombre;
private String descripcion;
private String titulo;
private String precio;

@NotNull
private String imagen;
}
