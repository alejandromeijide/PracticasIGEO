package com.companyname.springapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteManager {
	private static List<Cliente> listaclientes = new ArrayList<>();

	static {
		listaclientes.add(new Cliente(1, 2, "Alberto", "dgsg", "Madr", "Getafe"));
		listaclientes.add(new Cliente(2, 3, "Alex", "kuk", "Barcelona", "Barna"));
	
		
	}
	
	

//public boolean registrar(Cliente cliente) {
	//boolean registrar = false;	
	//Statement stm= null;
	//listaclientes.add(cliente);	
	//return registrar;
//}

	public static Cliente buscarClienteById(Integer id) {

		Cliente clienteDev = null;

		for (Cliente cli : listaclientes) {
			if (cli.getId().equals(id)) {
				clienteDev = cli;
				break;
			}
		}
		return clienteDev;

	}

public static Cliente guardarCliente(Cliente cliente){
	
	if(cliente.getId() == null)
	{// Es una creación
		cliente.setId(ClienteManager.obtenerId());
	}
	else
	{
		ClienteManager.eliminarClienteById(cliente.getId());
	}
	
	listaclientes.add(cliente);

	return cliente; 
	
} 

public static String eliminarClienteById(int id) {
	
	Cliente clienteOri = buscarClienteById(id);
	boolean confEli = listaclientes.remove(clienteOri); 
	if(confEli){ 
		return "Registro eliminado Satisfactoriamente"; }
	else{ 
		return "No se pudo eliminar el cliente"; } 
	} 


public static List<Cliente> obtenerClientes() {
	
	 return listaclientes;
}

private static int obtenerId() {
	
	Integer max = listaclientes.stream().map(Cliente::getId).max(Integer::compare).get() + 1;
	return max;
}

}
