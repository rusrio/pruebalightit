package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.UsuarioPedidoVO;

public interface ServicioUsuarioPedido {

	<S extends UsuarioPedidoVO> S save(S entity);

	<S extends UsuarioPedidoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioPedidoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioPedidoVO> findAll();

	Iterable<UsuarioPedidoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioPedidoVO entity);

	void deleteAll(Iterable<? extends UsuarioPedidoVO> entities);

	void deleteAll();

}