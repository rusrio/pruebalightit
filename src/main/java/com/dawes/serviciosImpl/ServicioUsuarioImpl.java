package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UsuarioRepository;
import com.dawes.servicios.ServicioUsuario;

@Service
public class ServicioUsuarioImpl implements UserDetailsService, ServicioUsuario {
	
	@Autowired
	UsuarioRepository ur;

	
	public <S extends UsuarioVO> S save(S entity) {
		return ur.save(entity);
	}

	
	public <S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ur.saveAll(entities);
	}


	public Optional<UsuarioVO> findById(Integer id) {
		return ur.findById(id);
	}


	public boolean existsById(Integer id) {
		return ur.existsById(id);
	}

	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}

	
	public Iterable<UsuarioVO> findAllById(Iterable<Integer> ids) {
		return ur.findAllById(ids);
	}


	public long count() {
		return ur.count();
	}


	public void deleteById(Integer id) {
		ur.deleteById(id);
	}


	public void delete(UsuarioVO entity) {
		ur.delete(entity);
	}


	public void deleteAll(Iterable<? extends UsuarioVO> entities) {
		ur.deleteAll(entities);
	}


	public void deleteAll() {
		ur.deleteAll();
	}
	

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("ha encontrado a "+ur.findByUsername(nombre).getPassword());
		return ur.findByUsername(nombre);
	}

	public UsuarioVO findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return ur.findByNombre(nombre);
	}
	
	public UsuarioVO generar_nombre(UsuarioVO usuario) {
		usuario.setNombre(usuario.getUsername());
		return usuario;
	}

	public UserDetails findByUsername(String nombre) {
		return ur.findByUsername(nombre);
	}
	


	
}
