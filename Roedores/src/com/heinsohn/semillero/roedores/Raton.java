package com.heinsohn.semillero.roedores;

/**
 * Clase Raton que hereda de la clase padre Roedores
 * @author josem
 *
 */
public class Raton implements Roedores{

	/**Metodo redefinido de la clase padre para que retorne el nombre del roedor tipo raton.
	 * 
	 * @return String, RATON
	 */
	@Override
	public String obtenerNombreRoedor() {
		// TODO Auto-generated method stub
		return "RATON";
	}

	/**Metodo redefinido de la clase padre para que retorne el alimento común del roedor tipo raton.
	 * 
	 * @return String, Queso.
	 */
	@Override
	public String alimentar() {
		// TODO Auto-generated method stub
		return "Queso";
	}

	
}
