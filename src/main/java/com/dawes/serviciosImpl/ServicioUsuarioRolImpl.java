package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UsuarioRolRepository;
import com.dawes.servicios.ServicioUsuarioRol;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol {
	@Autowired
	UsuarioRolRepository urop;

	@Override
	public <S extends UsuarioRolVO> S save(S entity) {
		return urop.save(entity);
	}

	@Override
	public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return urop.saveAll(entities);
	}

	@Override
	public Optional<UsuarioRolVO> findById(Integer id) {
		return urop.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return urop.existsById(id);
	}

	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return urop.findAll();
	}

	@Override
	public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
		return urop.findAllById(ids);
	}

	@Override
	public long count() {
		return urop.count();
	}

	@Override
	public void deleteById(Integer id) {
		urop.deleteById(id);
	}

	@Override
	public void delete(UsuarioRolVO entity) {
		urop.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
		urop.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		urop.deleteAll();
	}
	
	public void deleteByUsuario(UsuarioVO usuario) {
		urop.deleteByUsuario(usuario);
	}
	
	public void deleteByRol(RolVO rol) {
		urop.deleteByRol(rol);
	}
	
	
}
