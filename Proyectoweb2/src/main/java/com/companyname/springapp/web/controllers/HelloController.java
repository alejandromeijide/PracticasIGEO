package com.companyname.springapp.web.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;

@Controller
public class HelloController {

	protected final Log logger = LogFactory.getLog(getClass());


	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(Model model) {
		logger.info("Returning hello view");
		List<Cliente> obtenerClientes = ClienteManager.obtenerClientes();
		model.addAttribute("listaClientes", obtenerClientes);
		HashMap<Integer, Integer> a = new HashMap<>();
		return new ModelAndView("index.jsp");
	}


}
