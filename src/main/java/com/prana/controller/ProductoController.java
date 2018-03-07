package com.prana.controller;

import com.prana.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prana/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/nuevoProducto")
    public void crearProducto(){
         productoService.crearNuevoProducto();
    }
}
