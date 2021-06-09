package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioVO, Integer> {


	UserDetails findByUsername(String username);


	
}
