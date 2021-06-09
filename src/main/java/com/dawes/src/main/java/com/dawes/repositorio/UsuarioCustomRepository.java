package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.UsuarioCustomVO;
import com.dawes.modelo.UsuarioVO;

@Repository
public interface UsuarioCustomRepository extends CrudRepository<UsuarioCustomVO, Integer> {
	
	List<UsuarioCustomVO> findByCustom(CustomVO custom);
	
	List<UsuarioCustomVO> findByUsuario(UsuarioVO usuario);
	
}
