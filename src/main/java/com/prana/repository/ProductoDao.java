package com.prana.repository;

import com.prana.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends CrudRepository<Producto,Integer> {
}
