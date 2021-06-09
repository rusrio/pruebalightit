package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.CustomVO;

public interface ServicioCustom {

	<S extends CustomVO> S save(S entity);

	<S extends CustomVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<CustomVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<CustomVO> findAll();

	Iterable<CustomVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(CustomVO entity);

	void deleteAll(Iterable<? extends CustomVO> entities);

	void deleteAll();

}