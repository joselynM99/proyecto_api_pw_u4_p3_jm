package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteRepository {

	public Cliente buscarClientePorCedula(String cedula);
	
	public void insertarCliente(Cliente cliente);
	
	public void actualizarCliente(Cliente cliente);
	
	public List<Cliente> buscarClientesTodos();
	
	public void borrarClientePorId(Integer id);
	
	public void borrarClientePorCedula(String cedula);

	Cliente buscarClientePorId(Integer id);
	
	
	
}
