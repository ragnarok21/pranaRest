package com.prana.service;

import com.prana.domain.Cliente;

import java.util.List;

public interface ClienteService {
    void agregarCliente();
    List<Cliente> obtenerClientes();
}
