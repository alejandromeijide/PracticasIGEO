package com.companyname.springapp.web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
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
import com.companyname.springapp.web.validators.ClienteValidator;

@Controller
public class Controlador {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/hello2.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Returning hello viewww" + request);
		return new ModelAndView("hello.jsp");
	}

	@RequestMapping(value = "/hello3.htm")
	public ModelAndView hello3(@RequestParam(value = "param1", required = false) String param1) {
		logger.info("hello3" + param1);
		return new ModelAndView("hello.jsp");
	}

	@RequestMapping(value = "/eliminar-cliente/{id}", method = RequestMethod.POST)
	public @ResponseBody boolean postEliminarCliente(Model model, @PathVariable Integer id) {
		logger.info("postEliminarCliente" + id);

		ClienteManager.eliminarClienteById(id);

		List<Cliente> obtenerClientes = ClienteManager.obtenerClientes();
		model.addAttribute("listaClientes", obtenerClientes);

		return true;
	}

	@RequestMapping(value = "/crear-cliente", method = RequestMethod.GET)
	public ModelAndView getCrearCliente(Model model, @RequestParam(value = "id", required = false) Integer id) {
		logger.info("getCrearCliente" + id);
		Cliente cliente = new Cliente();
		if (id != null) {
			cliente = ClienteManager.buscarClienteById(id);
		}

		model.addAttribute("cliente", cliente);

		return new ModelAndView("crearcliente.jsp");

	}

	@RequestMapping(value = "/crear-cliente", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result,
			ModelMap model) {
		logger.info("submit");
		// ClienteValidator.validate(cliente, result);

		if (cliente.getId() == null) {
			Cliente clienteBusqueda = ClienteManager.buscarClienteById(cliente.getId());
			if (clienteBusqueda != null) {
				result.rejectValue("codigo", "codigo", "El codigo ya existe");
			}
		}

		if (result.hasErrors()) {

			model.addAttribute("cliente", cliente);

			return new ModelAndView("crearcliente.jsp");
		}

		ClienteManager.guardarCliente(cliente);

		// List<Cliente> obtenerClientes = ClienteManager.obtenerClientes();

		List<Cliente> obtenerClientes = ClienteManager.obtenerClientes();
		model.addAttribute("listaClientes", obtenerClientes);
		return new ModelAndView("index.jsp");

	}

}
