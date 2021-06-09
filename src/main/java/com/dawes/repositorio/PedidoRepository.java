package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.PedidoVO;
@Repository
public interface PedidoRepository extends CrudRepository<PedidoVO, Integer> {

}
