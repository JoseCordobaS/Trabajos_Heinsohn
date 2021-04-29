package com.heinsohn.semillero.roedores;

/**
 * Interface que representa animales de tipo roedores
 * 
 * @author josem
 *
 */

public interface Roedores {

	/**Metodo que retorna el nombre de cada roedor.
	 * 
	 * @return String, nombre roedor
	 */
	
	public String obtenerNombreRoedor() ;
	
	
	/**
	 * Metodo que retorna el alimento que consume principalmente cada roedor.
	 * @return String, tipo alimento
	 */
	public String alimentar();
	
}
