package com.fecha.modelo;
import java.io.Serializable;

public class ModeloData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5999303801389865002L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 81940582228261845L;
	
	private String mensaje0;
	private String mensaje;
	private String mensaje2;
	
	
	public void setMensaje0(String mensaje0) {
		this.mensaje0 = mensaje0;
	}
	public String getMensaje0() {
		return mensaje0;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
	public String getMensaje2() {
		return mensaje2;
	}
	
	
}
