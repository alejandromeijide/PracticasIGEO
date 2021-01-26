package com.fecha.modelo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fecha.modelo.ModeloData;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
//import java.sql.Date;
//import java.time.*;
import java.util.Date;

import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.temporal.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;





@RestController
//@RequestMapping(path="/rest/dataJR")
@RequestMapping(path="/diaSemanaAnioSiguiente.json")
public class REST {
	@GetMapping(path="/obtenDatos",produces= MediaType.APPLICATION_JSON_VALUE)

	
	public @ResponseBody ModeloData getDataFecha(@RequestParam(name="fecha")String message) {
		
		//Convierto el String a UN LocalDate para utilizar sus métodos.
		LocalDate localDate1 = LocalDate.parse(message, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("String -> java.time.LocalDate: " + localDate1);
		ModeloData response= new ModeloData();
		
		response.setMensaje0("Día solicitado: "+message);
		response.setMensaje("DíaSemanaFechaSolicitada:"+localDate1.getDayOfWeek());
		response.setMensaje2("DíaSemanaAnioSiguiente:"+localDate1.plusYears(1).getDayOfWeek());
		
		return response;
		
	}
	
	

}
