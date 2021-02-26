package com.companyname.springapp.web.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.companyname.springapp.model.Cliente;
import com.companyname.springapp.model.ClienteManager;

/**
 * Validador para cliente.
 * Controla que no tengamos codigos repetidos
 * 
 * @author Alejandro
 *
 */
@Component
public class ClienteValidator implements Validator {

	@Autowired private ClienteManager clienteManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.isAssignableFrom(clazz);
	}

	/**
	 * Validador
	 */
	@Override
	public void validate(Object objAValidar, Errors errors) {
		Cliente clienteAValidar = (Cliente) objAValidar;

		// Buscamos cliene por codigo
		Integer codigo = clienteAValidar.getCodigo();
		Cliente clienteBusqueda = clienteManager.buscarClienteByCodigo(codigo);
		
		if (clienteAValidar.getId() == null) {
			// Si es creación no dejamos crear si existe cliente con código
			if (clienteBusqueda != null) {
				errors.rejectValue("codigo", "codigo", "Error en la creación. El codigo ya existe");
			}
		}
		else{
			// Si es Edición comprobamos que el cliente encontrado es el que estamso editando
			if(clienteBusqueda != null && clienteBusqueda.getId() != clienteAValidar.getId()){
				errors.rejectValue("codigo", "codigo", "Error en la edición. El codigo ya existe.");
			}
		}

	}

}
