package com.prana.repository;

import com.prana.domain.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockDao extends CrudRepository<Stock, Integer> {
}
