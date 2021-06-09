package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioPedidoVO;
@Repository
public interface UsuarioPedidoRepository extends CrudRepository<UsuarioPedidoVO, Integer> {

}
