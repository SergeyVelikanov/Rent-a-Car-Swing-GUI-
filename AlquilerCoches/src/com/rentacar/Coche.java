package com.rentacar;
/**
 * 
 */


import javax.swing.JOptionPane;

/**
 * @author Sergey
 * 
 */
public class Coche
{
	private String matricula;
	private Integer kmActual;
	private Persona prs;

	/**
	 * 
	 * @param matricula
	 * @param kmActual
	 *            - actual car KM, if entered type is not a number 
	 *              then NumberFormatException error is being thrown
	 * @param nombre
	 * @param apellidos
	 *            for adding a car we need to fill all the input fields
	 */

	public Coche(String matricula,String kmActual,String nombre,String apellidos){
		if(matricula.isEmpty()||kmActual.isEmpty()||nombre.isEmpty()||apellidos.isEmpty())
			JOptionPane.showMessageDialog(null,"Debe introducir datos");
		else{
			this.matricula=matricula;
			try{
				this.kmActual=Integer.valueOf(kmActual);
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Campo 'KM' debe ser un numero entero");
			}
			prs=new Persona(nombre,apellidos);
			Vehiculo.aniadir(this);
		}
	}

	/**
	 * 
	 * @return  KM of this car
	 */

	public Integer getKm(){
		return this.kmActual;
	}

	/**
	 * 
	 * @return matricula of this car
	 */

	public String getMatricula(){
		return this.matricula;
	}

	/**
	 * 
	 * @return an instance of a Persona class
	 */

	public Persona getPrs(){
		return this.prs;
	}

}
