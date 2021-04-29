package com.heinsohn.semillero.roedores;

import java.util.ArrayList;
import java.util.List;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Roedores>roedores= new ArrayList<>();

		Roedores hamster = new Hamster();
		Roedores gerbo = new Gerbo();
		Roedores raton = new Raton();
		

		roedores.add(hamster);
		roedores.add(gerbo);
		roedores.add(raton);


		for (Roedores roedor : roedores) {
			System.out.println("Mi nombre de roedor es : " +roedor.obtenerNombreRoedor());
			System.out.println("Me alimento de : " +roedor.alimentar());


		}
	}

}
