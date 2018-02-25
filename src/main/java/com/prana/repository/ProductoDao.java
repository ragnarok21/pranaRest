package com.prana.repository;

import com.prana.domain.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto,Integer> {
}
