package com.heinsohn.semillero.roedores;

/**
 * Clase Gerbo que hereda de la clase padre Roedores
 * @author josem
 *
 */
public class Gerbo implements Roedores {

	/**Metodo redefinido de la clase padre para que retorne el nombre del roedor tipo Gerbo.
	 * 
	 * @return String, GERBO
	 */
	@Override
	public String obtenerNombreRoedor() {
		// TODO Auto-generated method stub
		return "GERBO";
	}

	/**Metodo redefinido de la clase padre para que retorne el alimento común del roedor tipo Gerbo.
	 * 
	 * @return String, Manzanas.
	 */
	@Override
	public String alimentar() {
		// TODO Auto-generated method stub
		return "Manzanas";
	}

}
