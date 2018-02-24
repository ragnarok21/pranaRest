package com.prana.service;

import com.prana.domain.Ciudad;
import com.prana.domain.Cliente;
import com.prana.domain.Region;
import com.prana.exceptions.NuevoClienteException;
import com.prana.repository.ClientDao;
import com.prana.repository.RegionDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private RegionDao regionDao;

    private static final Logger LOGGER = LogManager.getLogger(ClienteServiceImpl.class);


    public void  agregarCliente(){
        LOGGER.info("Guardando nuevo cliente");
        try{
            Region region = regionDao.getRegionPorId(8);

            Cliente cliente = new Cliente();
            cliente.setNombre( "Francisco" );
            cliente.setApellido( "Vergara" );
            cliente.setEmpresa( "Apiux" );
            cliente.setEmail("asdasdasdad");
            Ciudad ciudad = new Ciudad();
            ciudad.setNombre("San Carlos");
            ciudad.setRegion(region);
            cliente.setCiudad(ciudad);
            clientDao.save( cliente );
        }catch (Exception e){
            LOGGER.error("Error al guardar cliente [" + e.getMessage()+"]");
           throw new NuevoClienteException("Error al crear el cliente");
        }
    }

    public List<Cliente> obtenerClientes(){
        return (List<Cliente>) clientDao.findAll();
    }

}
