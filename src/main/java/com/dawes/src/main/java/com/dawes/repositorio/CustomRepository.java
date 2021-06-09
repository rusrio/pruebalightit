package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.CustomVO;

@Repository
public interface CustomRepository extends CrudRepository<CustomVO, Integer> {

}
