package com.heinsohn.semillero.ejercicios;

import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
/**
 * Clase main creada para la ejecución, contiene metodos estaticos con diferentes funcionalidades.
 * @author josem
 *
 */
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		boolean menu=true;

		while(menu==true) {
			System.out.println("Menú básico ejercicios 24 de Abril:\n"
					+ "1. Separar fecha \"22/07/1997\" \n"
					+ "2. Sumar enteros\n"
					+ "3. Sumar precios y decir el mayor\n"
					+ "4. SALIR\n");
			String opc = scanner.nextLine();

			switch (opc) {
			case "1":
				System.out.println(cadenaFecha()+"\n");
				break;
			case "2":
				System.out.println("El resultado de la suma es: "+sumarEnteros()+"\n"); 		
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

	/**Método que separa los valores del día,mes y año por medio de un token "/"
	 * 
	 * @return String, cadena con la fecha separada por espacios
	 */
	public static String cadenaFecha() {
		String fecha = "22/07/1997";

		String dia, mes, año, cadenaFecha;

		StringTokenizer tokens = new StringTokenizer(fecha, "/");
		dia = tokens.nextToken();
		mes = tokens.nextToken();
		año = tokens.nextToken();
		cadenaFecha = dia + " " + mes + " " + año;

		return cadenaFecha;
	}

	/**Método que realiza la suma de 5 enteros contenidos en un arreglo y retorna su resultado
	 * 
	 * @return int, resultado de la suma de los números del arreglo
	 */
	public static int sumarEnteros() {

		int suma = 0;
		String cSuma;
		int[] numeros = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}
		return suma;
	}
	
	/**Método que lee 5 precios por consola y realiza la suma de estos, si la suma total es mayor a 300
	 * le suma el 10% del precio total, de lo contrario solo suma el 7%. 
	 * 
	 * También el método indica cual fue el precio más alto ingresado.
	 * 
	 * @return
	 */
	
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
