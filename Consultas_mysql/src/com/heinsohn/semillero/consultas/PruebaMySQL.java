package com.heinsohn.semillero.consultas;

import java.sql.*;
import java.util.Scanner;

/**
 * PruebaMySQL.java
 *
 * Aplicacion de prueba para conexión a una base de datos de MySQL.
 * Se necesita que el motor BD ya ha arrancado, esta disponible y en el puerto por defecto.
 * Las credenciales de usuario y password de conexión con la base de datos debe cambiarse por las propias.
 * En la base de datos se supone que hay una base de datos llamada PERSONAS, que contiene
 * una tabla persona con cinco campos: 
 * 
 * Nombres -- varchar2, apellidos -- varchar2, 
 * sexo –- Varchar2, fecha nacimiento -- Date, salario -- NUMBER(8,2)
 * 
 */

public class PruebaMySQL {


	private static Connection conn;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user ="root";
	private static final String password= "Josema2018.";
	private static final String url= "jdbc:mysql://localhost:3306/db_personas";

	/** 
	 * Crea una instancia de la clase MySQL y realiza todo el código 
	 * de conexión
	 */

	public PruebaMySQL(){

		conn=null;

		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);

			if(conn != null) {
				System.out.println("Conexion establecida\n");
			}


		}
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Error al conectar : " +e);
		}
	}

	public static void Desconectar() {
		// Se cierra la conexión con la base de datos.
		conn= null;
		if(conn == null) {
			System.out.println("Conexion terminada");
		}
	}

	public static void MostrarNombresApellidosLongitud() {

		int i=1;
		String apellidos="";
		try {
			// Se crea un Statement, para realizar la consulta
			Statement s = conn.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el 
			// ResultSet rs
			ResultSet rs = s.executeQuery ("select * from persona");

			System.out.println ("# NOMBRES           APELLIDOS                   LONGITUD\n");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next())
			{
				apellidos= rs.getString("apellidos");

				System.out.println (i+"  "+ rs.getString ("nombres")+" " + rs.getString("apellidos")+
						" -> La LONGITUD de los apellidos es de: "+apellidos.length()+" caracteres \n");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void MostrarNombresDeMayores() {
		int i=1;
		String nombres="";
		try {
			// Se crea un Statement, para realizar la consulta
			Statement s = conn.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el 
			// ResultSet rs
			ResultSet rs = s.executeQuery ("select * from persona where Fecha_nacimiento > \"2010-01-01\"\r\n"+ "");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next())
			{
				nombres= rs.getString("nombres");
				String nombreMayuscula = nombres.toUpperCase();

				System.out.println (i+"  "+ nombreMayuscula+"\n");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CalcularPromedioSalarioPorSexo() {
		int i=1;
		try {
			// Se crea un Statement, para realizar la consulta
			Statement s = conn.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el 
			// ResultSet rs
			ResultSet rs = s.executeQuery ("select avg(SALARIO), sexo from persona group by sexo ");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next())
			{

				System.out.println ("\n"+i+"  "+rs.getString("avg(salario)")+"  "+rs.getString("sexo")+"\n");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PruebaMySQL();

		Scanner scanner = new Scanner(System.in);

		boolean menu=true;

		while(menu==true) {
			System.out.println("Menú Ejercicios consultas MySQL: \n\n"
					+ "1. Muestre una lista de los nombres y apellidos de las personas concatenados,\n "
					+ "con la primera letra en mayúscula, además, muestre la longitud total de los apellidos. \n"
					+ "\n2. Muestre los nombres de las personas en mayúscula cuya fecha de nacimiento sea mayor a 01/01/2010 \n"
					+ "\n3. Muestre el salario promedio (AVG) de las personas agrupadas por sexo. \n"
					+ "\n4. Del grupo anterior excluya los grupos cuyo promedio es menor a 1000 \n"
					+ "\n5. SALIR\n");
			String opc = scanner.nextLine();

			switch (opc) {
			case "1":
				MostrarNombresApellidosLongitud();
				break;
			case "2":
				MostrarNombresDeMayores();				
				break;
			case "3":
				CalcularPromedioSalarioPorSexo();
				break;
			case "4":
				break;
			case "5": Desconectar(); 
				menu=false;
			break;
			default:
				System.out.println("ingrese una opción correcta\n");
				break;
			}
		}
		

	}

}
