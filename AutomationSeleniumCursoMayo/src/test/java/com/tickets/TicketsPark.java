package com.tickets;

public abstract class TicketsPark {
	
	//Instancia de Variable o Instancia de Objeto
	String welcomeMessage;
	
	//Constructor
	public TicketsPark() {
		this.welcomeMessage = "Bienvenidos a Cooltesters Park -" ;
	}
	
	//Metodo Obtener Mensaje
	public String welcomeMessageString () {
	return this.welcomeMessage;
		
	}
	
	public abstract double getTicketPrice();
	public abstract void printPriceDay();
	public void printPriceDay(String authKey, String PriceDay) {
		
		
	}
		
}
