package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioProductoVO;
import com.dawes.repositorio.UsuarioProductoRepository;
import com.dawes.servicios.ServicioUsuarioProducto;
@Service
public class ServicioUsuarioProductoImpl implements ServicioUsuarioProducto {
	
	@Autowired
UsuarioProductoRepository uprr;

	@Override
	public <S extends UsuarioProductoVO> S save(S entity) {
		return uprr.save(entity);
	}

	@Override
	public <S extends UsuarioProductoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return uprr.saveAll(entities);
	}

	@Override
	public Optional<UsuarioProductoVO> findById(Integer id) {
		return uprr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return uprr.existsById(id);
	}

	@Override
	public Iterable<UsuarioProductoVO> findAll() {
		return uprr.findAll();
	}

	@Override
	public Iterable<UsuarioProductoVO> findAllById(Iterable<Integer> ids) {
		return uprr.findAllById(ids);
	}

	@Override
	public long count() {
		return uprr.count();
	}

	@Override
	public void deleteById(Integer id) {
		uprr.deleteById(id);
	}

	@Override
	public void delete(UsuarioProductoVO entity) {
		uprr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioProductoVO> entities) {
		uprr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		uprr.deleteAll();
	}
	
	
}
