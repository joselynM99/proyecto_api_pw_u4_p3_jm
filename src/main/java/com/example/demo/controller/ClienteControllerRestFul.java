package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IClienteService;
import com.example.demo.service.to.ClienteTO;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteControllerRestFul {

	@Autowired
	private IClienteService clienteService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void registrarCliente(@RequestBody ClienteTO cliente) {
		this.clienteService.registrarCliente(cliente);

		this.clienteService.encontrarClientesTodos();

	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody ClienteTO cliente) {
		cliente.setId(id);
		this.clienteService.actualizarCliente(cliente);
	}

	@GetMapping(path = "/porCedula/{cedula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ClienteTO buscarClientePorCedula(@PathVariable("cedula") String cedula) {
		return this.clienteService.buscarClientePorCedula(cedula);
	}
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteTO> buscarTodosClientes() {
		return this.clienteService.encontrarClientesTodos();
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ClienteTO encontrarClientePorId(@PathVariable("id") Integer id) {
		return this.clienteService.encontrarClientePorId(id);
	}

	@DeleteMapping(path = "/porCedula/{cedula}")
	public void eliminarClientePorCedula(@PathVariable("cedula") String cedula) {
		this.clienteService.eliminarClientePorCedula(cedula);
	}

	@DeleteMapping(path = "/{id}")
	public void eliminarClientePorId(@PathVariable("id") Integer id) {
		this.clienteService.eliminarClientePorId(id);
	}

}
