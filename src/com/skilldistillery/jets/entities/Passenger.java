package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements Board{

	public Passenger(String type, String model, int maxMph, int range, int price) {
		super(type, model, maxMph, range, price);
	}
	
}
