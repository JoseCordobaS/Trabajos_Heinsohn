package com.heinsohn.semillero.roedores;

/**
 * Clase Hamster que hereda de la clase padre Roedores
 * @author josem
 *
 */
public class Hamster implements Roedores {

	/**Metodo redefinido de la clase padre para que retorne el nombre del roedor tipo Hamster.
	 * 
	 * @return String, HAMSTER.
	 */	
	@Override
	public String obtenerNombreRoedor() {
		// TODO Auto-generated method stub
		return "HAMSTER";
	}

	/**Metodo redefinido de la clase padre para que retorne el alimento común del roedor tipo Hamster.
	 * 
	 * @return String, Zanahoria.
	 */
	@Override
	public String alimentar() {
		// TODO Auto-generated method stub
		return "Zanahoria";
	}

}
