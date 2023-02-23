package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente buscarClientePorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula", Cliente.class);
		myQuery.setParameter("cedula", cedula);

		return myQuery.getSingleResult();
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		this.entityManager.persist(cliente);

	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		this.entityManager.merge(cliente);

	}

	@Override
	public List<Cliente> buscarClientesTodos() {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c", Cliente.class);

		return myQuery.getResultList();
	}

	@Override
	public void borrarClientePorId(Integer id) {
		this.entityManager.remove(this.buscarClientePorId(id));

	}

	@Override
	public void borrarClientePorCedula(String cedula) {
		this.entityManager.remove(this.buscarClientePorCedula(cedula));

	}

}
