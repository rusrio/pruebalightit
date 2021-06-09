package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dawes.modelo.CustomVO;
import com.dawes.repositorio.CustomRepository;
import com.dawes.servicios.ServicioCustom;

@Service
public class ServicioCustomImpl implements ServicioCustom {
	
	CustomRepository cr;
	
	@Override
	public <S extends CustomVO> S save(S entity) {
		return cr.save(entity);
	}
	
	@Override
	public <S extends CustomVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<CustomVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<CustomVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<CustomVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(CustomVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends CustomVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	
	
	
}
