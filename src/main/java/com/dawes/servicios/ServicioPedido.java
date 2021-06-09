package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.PedidoVO;

public interface ServicioPedido {

	<S extends PedidoVO> S save(S entity);

	<S extends PedidoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PedidoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PedidoVO> findAll();

	Iterable<PedidoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PedidoVO entity);

	void deleteAll(Iterable<? extends PedidoVO> entities);

	void deleteAll();

}