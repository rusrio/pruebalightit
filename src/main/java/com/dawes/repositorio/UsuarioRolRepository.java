package com.dawes.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolVO, Integer> {

	@Transactional
	@Modifying
	void deleteByUsuario(UsuarioVO usuario);

	@Transactional
	@Modifying
	void deleteByRol(RolVO rol);
	
}
