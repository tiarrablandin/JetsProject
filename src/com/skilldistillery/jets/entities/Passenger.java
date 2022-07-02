package com.skilldistillery.jets.entities;

public class Passenger extends Jet {

	public Passenger(String type, String model, int maxMph, int range, int price) {
		super(type, model, maxMph, range, price);
	}
	
	public void board() {
		System.out.println("You are cleared to come aboard the aircraft.");
	}

}
