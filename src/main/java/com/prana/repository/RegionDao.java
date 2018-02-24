package com.prana.repository;

import com.prana.domain.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegionDao extends CrudRepository<Region,Integer> {
    @Query("select c from Region c where c.nombre = ?1")
    Region getRegionPorNombre(String nombreRegion);

    @Query("select c from Region c where c.id = ?1")
    Region getRegionPorId(Integer idRegion);
}
