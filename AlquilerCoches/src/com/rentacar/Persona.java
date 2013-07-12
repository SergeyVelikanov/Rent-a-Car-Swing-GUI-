package com.rentacar;
/**
 * 
 */


/**
 * @author Sergey
 * 
 */
public class Persona
{
	private String nombre;
	private String apellidos;

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 */

	public Persona(String nombre,String apellidos){
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	/**
	 * 
	 * @return String with nombre and apellidos
	 */

	public String getInfo(){
		return this.nombre+" "+this.apellidos;
	}
}
