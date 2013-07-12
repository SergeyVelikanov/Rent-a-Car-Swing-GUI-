package com.rentacar;
/**
 * 
 */


import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public abstract class Vehiculo
{
	private static ArrayList<Coche> alquilado=new ArrayList<Coche>();

	/**
	 * 
	 * @param c
	 *            - an instance of the Coche class to add  to the list
	 */
	public static void aniadir(Coche c){
		alquilado.add(c);
	}

	/**
	 * 
	 * @param kmDesde
	 * @param kmHasta
	 * @return String with a car data and of a person according to the search parameters
	 */

	public static String buscar(String kmDesde,String kmHasta){
		String str;
		try{
			str="Matricula"+"         "+"KM"+"               "+"Persona";
			for(Coche c:alquilado){
				if(c.getKm()>=Integer.valueOf(kmDesde)&&c.getKm()<=Integer.valueOf(kmHasta))
					str+="\n"+c.getMatricula()+"       "+c.getKm()+"      "+c.getPrs().getInfo();
			}
		}catch(Exception error){
			return "Datos introducidos incorrectos";
		}
		return str;
	}

	/**
	 * 
	 * @return String with all the data of all cars in the list
	 */

	public static String listarTodo(){
		String str="Matricula"+"         "+"KM"+"               "+"Persona";
		for(Coche c:alquilado)
			str+="\n"+c.getMatricula()+"       "+c.getKm()+"      "+c.getPrs().getInfo();
		return str;
	}

}
