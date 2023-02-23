package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.service.to.ClienteTO;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public ClienteTO buscarClientePorCedula(String cedula) {
		return this.convertirClienteTO(this.clienteRepository.buscarClientePorCedula(cedula));
	}

	@Override
	public void registrarCliente(ClienteTO cliente) {
		this.clienteRepository.insertarCliente(this.convertirCliente(cliente));
	}

	@Override
	public void actualizarCliente(ClienteTO cliente) {
		this.clienteRepository.actualizarCliente(this.convertirCliente(cliente));
	}

	@Override
	public List<ClienteTO> encontrarClientesTodos() {

		List<Cliente> lista = this.clienteRepository.buscarClientesTodos();
		List<ClienteTO> listaFinal = lista.stream().map(cliente -> this.convertirClienteTO(cliente))
				.collect(Collectors.toList());

		return listaFinal;
	}

	@Override
	public void eliminarClientePorId(Integer id) {
		this.clienteRepository.borrarClientePorId(id);
	}

	@Override
	public void eliminarClientePorCedula(String cedula) {
		this.clienteRepository.borrarClientePorCedula(cedula);
	}

	@Override
	public ClienteTO encontrarClientePorId(Integer id) {
		return this.convertirClienteTO(this.clienteRepository.buscarClientePorId(id));
	}

	private ClienteTO convertirClienteTO(Cliente cliente) {
		ClienteTO clie = new ClienteTO();
		clie.setApellido(cliente.getApellido());
		clie.setCedula(cliente.getCedula());
		clie.setEmail(cliente.getEmail());
		clie.setFechaNacimiento(cliente.getFechaNacimiento());
		clie.setGenero(cliente.getGenero());
		clie.setId(cliente.getId());
		clie.setNombre(cliente.getNombre());

		return clie;
	}

	private Cliente convertirCliente(ClienteTO cliente) {
		Cliente clie = new Cliente();
		clie.setApellido(cliente.getApellido());
		clie.setCedula(cliente.getCedula());
		clie.setEmail(cliente.getEmail());
		clie.setFechaNacimiento(cliente.getFechaNacimiento());
		clie.setGenero(cliente.getGenero());
		clie.setId(cliente.getId());
		clie.setNombre(cliente.getNombre());

		return clie;
	}
}
