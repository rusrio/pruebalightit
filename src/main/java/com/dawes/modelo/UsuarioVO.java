package com.dawes.modelo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@Entity
@Table(name = "usuarios")

public class UsuarioVO implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idusuario;
	
@NotNull
@Column(unique=true)
private String username;
private String nombre;

@NotNull
private String password;
private LocalDate fechaRegistro;

public UsuarioVO(int idusuario, String username, String nombre, String password, LocalDate fechaRegistro, List<UsuarioRolVO> roles) {
	super();
	this.idusuario = idusuario;
	this.username = username;
	this.nombre = username;
	this.password = password;
	this.fechaRegistro = fechaRegistro;
	this.roles = roles;
}

@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
List<UsuarioRolVO> roles;

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return null;
}
@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}

}
