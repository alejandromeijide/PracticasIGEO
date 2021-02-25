package com.companyname.springapp.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;

public class ClientesManagerTest {

	
	
	@Test
	public void testGuardarCliente() {
		
		
		
		Cliente cliente1=  new Cliente(1, 1, "Adolfo", "wer", "Madrid", "Alcalá");
		ClienteManager.guardarCliente(cliente1);
		
		Cliente cliente2=ClienteManager.buscarClienteById(1);
		//Cliente cliente2=  new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");
		
		
		Assert.assertEquals(cliente1, cliente2);
		
	}
	
	
	@Test
	public void testActCliente() {
		
		Cliente cliente1 = ClienteManager.guardarCliente(new Cliente(null, 1, "Adolfo", "wer", "Madrid", "Alcalá"));

		cliente1.setNombre("PEPE");

		System.out.println(ClienteManager.guardarCliente(cliente1));

		Cliente clienteExpected1 = ClienteManager.buscarClienteById(cliente1.getId());
		Assert.assertEquals(clienteExpected1.getNombre(), "PEPE");
		
		
	}
	
	@Test
	public void testEliminarCliente() {

		ClienteManager.eliminarClienteById(2);

		List<Cliente> tamañoLista = ClienteManager.obtenerClientes();

		int tamaño = tamañoLista.size();

		Assert.assertEquals(tamaño, 1);

		// ClienteManager.buscarClienteByCodigo(2);
		// Cliente cliente2= new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");

	}
	
	@Test
	public void testActualizarCliente() {

		ClienteManager.eliminarClienteById(2);

		List<Cliente> tamañoLista = ClienteManager.obtenerClientes();

		int tamaño = tamañoLista.size();

		Assert.assertEquals(tamaño, 1);

		// ClienteManager.buscarClienteByCodigo(2);
		// Cliente cliente2= new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");

	}


	
	

}
