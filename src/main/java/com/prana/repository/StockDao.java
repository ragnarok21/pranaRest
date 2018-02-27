package com.prana.repository;

import com.prana.domain.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends CrudRepository<Stock, Integer> {
}
