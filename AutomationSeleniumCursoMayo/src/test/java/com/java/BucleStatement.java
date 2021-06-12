package com.java;

public class BucleStatement {

	public static void main(String[] args) {

	//while
	
	int numero =1;
	
	while (numero <=10) {
		
		//BlockCode
		
		System.out.println("El número es:"+numero);
		++numero;
	}
	
	//Do while se hace algo mientras se cumpla una condicion
	
	//Cuantas veces se debe sumar un mismo numero para llegar a 20
	
	int numerolimite = 20;
	int sumtotal = 0;
	int count  = 0;
	
	do {
	sumtotal  = sumtotal + numerolimite;  
// operador unario
// sumtotal +=numerolimite 
	
	++count;   
// count = count + 1
// ++count
	
	} while (sumtotal < 100);
	
	System.out.println("El numero se sumo ="+count);
	
    // For
	
	int numerofor = 10;
	
	for (int i=1; i <= numerofor; i++ ) {
	
	System.out.println("El numero for es:"+ i);
	}

	
	
	}

}
