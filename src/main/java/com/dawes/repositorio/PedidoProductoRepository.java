package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.PedidoProductoVO;

@Repository
public interface PedidoProductoRepository extends CrudRepository<PedidoProductoVO, Integer> {

}
