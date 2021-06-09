package com.dawes.servicios;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuario {
	
	<S extends UsuarioVO> S save(S entity);

	<S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioVO> findAll();

	Iterable<UsuarioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioVO entity);

	void deleteAll(Iterable<? extends UsuarioVO> entities);

	void deleteAll();

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}