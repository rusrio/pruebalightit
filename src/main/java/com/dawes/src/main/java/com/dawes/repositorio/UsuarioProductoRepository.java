package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioProductoVO;
@Repository
public interface UsuarioProductoRepository extends CrudRepository<UsuarioProductoVO, Integer> {

}
