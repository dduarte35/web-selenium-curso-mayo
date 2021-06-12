package com.java;

public class LimiteVelocidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int velocidad = 130; //KM/H
		int limitevelocidad = 100;
		
//		if (velocidad > limitevelocidad) {
//			System.out.println("MULTA");
//		} else {
//			System.out.println("El auto va a velocidad adecuada");
//		}
		
		//If anidado / If Else
		
		boolean highway = true; 
		
		if(highway) {
		System.out.println("Estamos conduciendo en una highway");
		
		limitevelocidad = 120; 
		
		if (velocidad > limitevelocidad) {
		System.out.println("MULTA!");
	    } else {
		System.out.println("El auto va a velocidad adecuada");
	    }} else if (velocidad > limitevelocidad) {
		System.out.println("El coche esta en una calle y va a exceso de velocidad, MULTA!");
		} else {
		System.out.println("El coche esta en una calle y va a una velocidad permitida");	
		}
	
		// switch case
		
		int temperatura = 20;
		
		switch (temperatura) {
		case 5:
			System.out.println("Mucho Frio");			
		break;
		
		case 10:
			System.out.println("Frio");		
			break;
		
		case 15:
			System.out.println("Templado");		
			break;
		
		case 35:
			System.out.println("Calor");
			break;
		
		default:
			System.out.println("No encontro relación con la temperatura");
	}

	

	}
	}

