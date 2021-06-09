package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.UsuarioCustomVO;
import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuarioCustom {

	<S extends UsuarioCustomVO> S save(S entity);

	<S extends UsuarioCustomVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioCustomVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioCustomVO> findAll();

	Iterable<UsuarioCustomVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioCustomVO entity);

	void deleteAll(Iterable<? extends UsuarioCustomVO> entities);

	void deleteAll();

	List<UsuarioCustomVO> findByUsuario(UsuarioVO usuario);
	
	List<UsuarioCustomVO> findByCustom(CustomVO custom);

}