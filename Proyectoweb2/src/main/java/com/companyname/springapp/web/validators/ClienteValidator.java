package com.companyname.springapp.web.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;


public class ClienteValidator implements Validator {

	@Autowired private ClienteManager clienteManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
/*		Cliente command = (Cliente) target;

		Integer codigo = command.getCodigo();

		if (StringUtils.isEmpty(codigo) == false) {
			Cliente clienteBusqueda = ClienteManager.buscarClienteByCodigo(codigo);
			if (clienteBusqueda != null) {
				errors.rejectValue("codigo", "codigo", "El codigo ya existe");
			}
		}
*/
	}

}
