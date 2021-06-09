package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.PedidoProductoVO;

public interface ServicioPedidoProducto {

	<S extends PedidoProductoVO> S save(S entity);

	<S extends PedidoProductoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PedidoProductoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PedidoProductoVO> findAll();

	Iterable<PedidoProductoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PedidoProductoVO entity);

	void deleteAll(Iterable<? extends PedidoProductoVO> entities);

	void deleteAll();

}