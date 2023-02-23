package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.ClienteTO;

public interface IClienteService {
	
	public ClienteTO buscarClientePorCedula(String cedula);

	public void registrarCliente(ClienteTO cliente);

	public void actualizarCliente(ClienteTO cliente);

	public List<ClienteTO> encontrarClientesTodos();

	public void eliminarClientePorId(Integer id);

	public void eliminarClientePorCedula(String cedula);

	ClienteTO encontrarClientePorId(Integer id);
}
