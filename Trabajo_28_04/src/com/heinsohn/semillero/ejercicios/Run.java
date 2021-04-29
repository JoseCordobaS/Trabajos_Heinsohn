package com.heinsohn.semillero.ejercicios;

import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		boolean menu=true;

		while(menu==true) {
			System.out.println("Menú básico ejercicios 24 de Abril:\n"
					+ "1. Separar fecha 22/07/1997 \n"
					+ "2. Sumar enteros\n"
					+ "3. Sumar precios y decir el mayor\n"
					+ "4. SALIR\n");
			String opc = scanner.nextLine();

			switch (opc) {
			case "1":
				System.out.println(cadenaFecha()+"\n");
				break;
			case "2":
				System.out.println(sumarEnteros()+"\n");
				break;
			case "3":
				System.out.println(calcularPrecio()+"\n");
				break;
			case "4": menu=false;
				break;
			default:
				System.out.println("ingrese una opción correcta\n");
				break;
			}
		}

	}

	public static String cadenaFecha() {
		String fecha = "22/07/1997";

		String dia, mes, año, cadenaFecha;
		double[] fecha_separada;

		StringTokenizer tokens = new StringTokenizer(fecha, "/");
		dia = tokens.nextToken();
		mes = tokens.nextToken();
		año = tokens.nextToken();
		cadenaFecha = dia + " " + mes + " " + año;

		return cadenaFecha;
	}

	public static String sumarEnteros() {

		int suma = 0;
		String cSuma;
		int[] numeros = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}
		cSuma = "El resultado de la suma es: " + suma;
		return cSuma;
	}
	
	public static String calcularPrecio() {

		Scanner scanner = new Scanner(System.in);

		String cadena_salida;
		double suma = 0,precioMayor=0;
		
		double []precios= new double[5];
		
		for (int i=0;i<precios.length;i++) {
			System.out.println("Ingrese el precio del producto: "+(i+1));
			precios[i]= scanner.nextDouble();
			suma+=precios[i];
			System.out.println("SUMAAAAAAAAAAAA " +suma);
			if(precios[i]>precioMayor) {
				precioMayor=precios[i];
			}
			
		}
		
		if(suma>300) {
			suma+=(suma*0.10);
		}
		else {
			suma+=(suma*0.07);
		}
		cadena_salida= "El precio total es: "+suma +" y el precio más alto fue: "+ precioMayor;
		return cadena_salida;
	}

}
