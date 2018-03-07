package com.prana.controller;

import com.prana.domain.Cliente;
import com.prana.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prana/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @RequestMapping("/all")
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(){
        clienteService.agregarCliente();
    }

}
