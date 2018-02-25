package com.prana.service.impl;

import com.prana.domain.Producto;
import com.prana.domain.Stock;
import com.prana.domain.TipoProducto;
import com.prana.repository.ProductoDao;
import com.prana.repository.StockDao;
import com.prana.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private StockDao stockDao;

    private static final Logger LOGGER = LogManager.getLogger(ClienteServiceImpl.class);



    @Override
    public void crearNuevoProducto() {

        Date date = new Date(System.currentTimeMillis());
        Producto producto = new Producto();
        Stock stock = new Stock();
        stock.setStock(200);
        stock.setUltima_actualizacion(new Timestamp(date.getTime()));
        producto.setNombre("Aguita 123");
        producto.setDescripcion("aguita muy rica");
        producto.setPrecioUnidad(12323);
        producto.setTipoProducto(TipoProducto.EMBOTELLADA);
        stock.setProducto(producto);
        try{
            productoDao.save(producto);
            stockDao.save(stock);
        }catch (Exception e){
            LOGGER.error("Error al crear producto");
        }

    }
}
