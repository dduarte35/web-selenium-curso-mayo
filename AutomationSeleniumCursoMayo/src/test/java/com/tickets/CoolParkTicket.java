package com.tickets;

public class CoolParkTicket extends TicketsPark {

	double adultTicket;
	double childTicket;
	double studentTicket;
	boolean student = false;
	String priceDay;
	String park;
	int age;

	public CoolParkTicket(double price, boolean student, int age) {
		super ();
		this.adultTicket = price;
		this.childTicket = price * (0.80);
		this.studentTicket = price * (0.50);
		this.student = student;
		this.priceDay = "Precio del Día Regular";
		this.park = "Cool Park";
		this.age = age;

	}

	//Encapsular Precio (Encapsulacion)
	private void setPriceDay(String priceDay) {
		this.priceDay = priceDay;
	}
	
	private String getpriceDay() {
		return priceDay;
	}
	
	@Override
	public double getTicketPrice() {
		double priceTicket;
		
		if(age>=18 && !student) {
		priceTicket = adultTicket;
		System.out.println("Precio Adulto: $"+adultTicket);
		} else if (age >=18 && student) {
			priceTicket = studentTicket;
		System.out.println("Precio Estudiante: $"+studentTicket);
		} else {
			priceTicket = childTicket;
		System.out.println("Precio Nino: $"+childTicket);
		}
		return 0;
	}

	@Override
	public void printPriceDay() {
		System.out.println(welcomeMessageString() + park + getpriceDay());
	
	}

	public void printPriceDay(String authKey, String PriceDay) {
	setPriceDay(PriceDay);
	System.out.println(welcomeMessageString() + park + getpriceDay());
		
	}
	
}
