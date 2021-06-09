package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.ProductoVO;

public interface ServicioProducto {

	<S extends ProductoVO> S save(S entity);

	<S extends ProductoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ProductoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ProductoVO> findAll();

	Iterable<ProductoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ProductoVO entity);

	void deleteAll(Iterable<? extends ProductoVO> entities);

	void deleteAll();

}