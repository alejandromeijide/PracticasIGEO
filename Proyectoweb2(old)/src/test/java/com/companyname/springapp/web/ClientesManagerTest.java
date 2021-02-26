package com.companyname.springapp.web;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;


@RunWith(SpringJUnit4ClassRunner.class)
public class ClientesManagerTest {

	@Autowired ClienteManager clienteManager;
	
	@Test
	public void testGuardarCliente() {
		
		
		
		Cliente cliente1=  new Cliente(1, 1, "Adolfo", "wer", "Madrid", "Alcalá");
		clienteManager.guardarCliente(cliente1);
		
		Cliente cliente2=clienteManager.buscarClienteById(1);
		//Cliente cliente2=  new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");
		
		
		Assert.assertEquals(cliente1, cliente2);
		
	}
	
	
	@Test
	public void testActCliente() {
		
		Cliente cliente1 = clienteManager.guardarCliente(new Cliente(null, 1, "Adolfo", "wer", "Madrid", "Alcalá"));

		cliente1.setNombre("PEPE");

		System.out.println(clienteManager.guardarCliente(cliente1));

		Cliente clienteExpected1 = clienteManager.buscarClienteById(cliente1.getId());
		Assert.assertEquals(clienteExpected1.getNombre(), "PEPE");
		
		
	}
	
	@Test
	public void testEliminarCliente() {

		clienteManager.eliminarClienteById(2);

		List<Cliente> tamañoLista = clienteManager.obtenerClientes();

		int tamaño = tamañoLista.size();

		Assert.assertEquals(tamaño, 1);

		// ClienteManager.buscarClienteByCodigo(2);
		// Cliente cliente2= new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");

	}
	
	@Test
	public void testActualizarCliente() {

		clienteManager.eliminarClienteById(2);

		List<Cliente> tamañoLista = clienteManager.obtenerClientes();

		int tamaño = tamañoLista.size();

		Assert.assertEquals(tamaño, 1);

		// ClienteManager.buscarClienteByCodigo(2);
		// Cliente cliente2= new Cliente(1, "Adolfo", "wer", "Madrid", "Alcalá");

	}


	
	

}
