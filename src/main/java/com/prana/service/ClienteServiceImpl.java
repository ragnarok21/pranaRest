package com.prana.service;

import com.prana.domain.Cliente;
import com.prana.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClientDao clientDao;

    public void  agregarCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre( "Francisco" );
        cliente.setApellido( "Vergara" );
        cliente.setEmpresa( "Apiux" );
        clientDao.save( cliente );
    }

    public List<Cliente> obtenerClientes(){
        return (List<Cliente>) clientDao.findAll();
    }

}
