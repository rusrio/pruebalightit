package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.UsuarioProductoVO;

public interface ServicioUsuarioProducto {

	<S extends UsuarioProductoVO> S save(S entity);

	<S extends UsuarioProductoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioProductoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioProductoVO> findAll();

	Iterable<UsuarioProductoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioProductoVO entity);

	void deleteAll(Iterable<? extends UsuarioProductoVO> entities);

	void deleteAll();

}