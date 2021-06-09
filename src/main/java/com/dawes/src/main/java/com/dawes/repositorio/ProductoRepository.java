package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ProductoVO;
@Repository
public interface ProductoRepository extends CrudRepository<ProductoVO, Integer> {

}
