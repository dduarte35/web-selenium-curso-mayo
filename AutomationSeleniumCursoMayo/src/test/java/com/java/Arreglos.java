package com.java;

public class Arreglos {

	public static void main(String[] args) {

		//Arreglo Unidimensional
		
	    String[] nombres = {"Ricardo", "Jessica", "Aide", "Felipe", "Luis"};
		
//		System.out.println("El nombre de la persona es: " +nombres [3]);
	
		for (int i=0; i<nombres.length; i++) {
		System.out.println("El nombre de la persona es:" +nombres [i]);
		}

		//Arreglo Bidimensional
		
		String[][] nombreEdad = new String [4][4];
		
		nombreEdad [0][0] = "Ricardo";
		nombreEdad [0][1] = "30";
		nombreEdad [1][0] = "Jessica";
		nombreEdad [1][1] = "31";
		nombreEdad [2][0] = "Aide";
		nombreEdad [2][1] = "32";
		nombreEdad [3][0] = "Felipe";
		nombreEdad [3][1] = "33";
		
		System.out.println("El nombre de la persona es:"+nombreEdad [0][0]+ "y su edad es:"+nombreEdad [0][1]);
	
		
	}
	
		//Metodo
//		public static void String printNombreEdad (String nombre, string edad) {
//		System.out.println("El nombre de la persona es:"+nombre "y su edad es:"+edad));	
		
//		}
		
//		public static int suma(int)
		
//	}

}
