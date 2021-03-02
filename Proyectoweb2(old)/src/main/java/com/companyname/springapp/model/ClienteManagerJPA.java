package com.companyname.springapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.springapp.repository.ClienteRepository;

//@Service
public class ClienteManagerJPA {
	/*
	@Autowired
	private ClienteRepository clienteRepository;
	

//public boolean registrar(Cliente cliente) {
	//boolean registrar = false;	
	//Statement stm= null;
	//listaclientes.add(cliente);	
	//return registrar;
//}

	public  Cliente buscarClienteById(Integer id) {
		return clienteRepository.findById(id);
	}
	
	public  Cliente buscarClienteByCodigo(Integer codigo) {

		return clienteRepository.findByCodigo(codigo);

	}

public Cliente guardarCliente(Cliente cliente){
	
//	if(cliente.getId() == null)
//	{// Es una creación
//		cliente.setId(obtenerId());
//	}
//	else
//	{// Es una edición
//		eliminarClienteById(cliente.getId());
//	}
//	
//	listaclientes.add(cliente);
	
	clienteRepository.save(cliente);

	return cliente; 
	
} 

public boolean eliminarClienteById(int id) {

	try {
		Cliente clienteOri = buscarClienteById(id);
		clienteRepository.delete(clienteOri);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;	
	}
	return true;
}


public List<Cliente> obtenerClientes() {
	 return clienteRepository.findAll();
}

private int obtenerId() {
	
	Integer max = obtenerClientes().stream().map(Cliente::getId).max(Integer::compare).get() + 1;
	return max;
}
*/
}
