package com.companyname.springapp.web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;
import com.companyname.springapp.model.web.model.enums.Delegaciones;
import com.companyname.springapp.model.web.model.enums.Provincias;
import com.companyname.springapp.web.validators.ClienteValidator;

@Controller
public class Controlador {

	@Autowired
	ClienteManager clienteManager;
	@Autowired
	ClienteValidator clienteValidator;

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Pagina principal
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(Model model) {
		logger.info("Returning hello view");

		// Populamos la lista de clientes
		populaListaClientes(model);

		return new ModelAndView("index.jsp");
	}

	/**
	 * Post para eliminar cliente
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/eliminar-cliente/{id}", method = RequestMethod.POST)
	public @ResponseBody boolean postEliminarCliente(Model model, @PathVariable Integer id) {
		logger.info("postEliminarCliente" + id);
		// Eliminamos cliente
		boolean borrado = clienteManager.eliminarClienteById(id);
		return borrado;
	}

	/**
	 * Get para crear/editar cliente
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/crear-cliente", method = RequestMethod.GET)
	public ModelAndView getCrearCliente(Model model, @RequestParam(value = "id", required = false) Integer id) {
		logger.info("getCrearCliente" + id);
		Cliente cliente = new Cliente();
		if (id != null) {
			cliente = clienteManager.buscarClienteById(id);
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("delegaciones", Delegaciones.values());
		model.addAttribute("provincias", Provincias.values());

		return new ModelAndView("crearcliente.jsp");
	}

	/**
	 * Post para crear/editar cliente
	 * 
	 * @param cliente
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/crear-cliente", method = RequestMethod.POST)
	public ModelAndView postCrearCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
		logger.info("postCrearCliente: " + cliente.getId());

		// Validación
		clienteValidator.validate(cliente, result);

		// Redireción si hay errores
		if (result.hasErrors()) {
			model.addAttribute("cliente", cliente);
			return new ModelAndView("crearcliente.jsp");
		}

		// Acciones
		clienteManager.guardarCliente(cliente);

		// Populamos la lista de clientes
		populaListaClientes(model);

		// Redirección si no hay errores
		return new ModelAndView("index.jsp");

	}

	/**
	 * Metodo que popula la lista de clientes
	 */
	private void populaListaClientes(Model model) {
		// Relleno de datos para la capa de vista
		List<Cliente> obtenerClientes = clienteManager.obtenerClientes();
		model.addAttribute("listaClientes", obtenerClientes);
	}

}
