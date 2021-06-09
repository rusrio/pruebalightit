package com.dawes.serviciosImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.UsuarioCustomVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UsuarioCustomRepository;
import com.dawes.servicios.ServicioUsuarioCustom;

@Service
public class ServicioUsuarioCustomImpl implements ServicioUsuarioCustom {
	
	@Autowired
	UsuarioCustomRepository ucr;

@Override
public <S extends UsuarioCustomVO> S save(S entity) {
	return ucr.save(entity);
}

@Override
public <S extends UsuarioCustomVO> Iterable<S> saveAll(Iterable<S> entities) {
	return ucr.saveAll(entities);
}

@Override
public Optional<UsuarioCustomVO> findById(Integer id) {
	return ucr.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return ucr.existsById(id);
}

@Override
public Iterable<UsuarioCustomVO> findAll() {
	return ucr.findAll();
}

@Override
public Iterable<UsuarioCustomVO> findAllById(Iterable<Integer> ids) {
	return ucr.findAllById(ids);
}

@Override
public long count() {
	return ucr.count();
}

@Override
public void deleteById(Integer id) {
	ucr.deleteById(id);
}

@Override
public void delete(UsuarioCustomVO entity) {
	ucr.delete(entity);
}

@Override
public void deleteAll(Iterable<? extends UsuarioCustomVO> entities) {
	ucr.deleteAll(entities);
}

@Override
public void deleteAll() {
	ucr.deleteAll();
}

@Override
public List<UsuarioCustomVO> findByUsuario(UsuarioVO usuario) {
	return ucr.findByUsuario(usuario);
}

@Override
public List<UsuarioCustomVO> findByCustom(CustomVO custom) {
	return ucr.findByCustom(custom);
}



	
 
 
}
