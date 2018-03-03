package com.prana.repository;

import com.prana.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends CrudRepository<Cliente,Integer> {
    @Query("select c from Cliente c where c.username = ?1")
    Cliente getClienteByUsername(String username);

}
