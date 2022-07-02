package com.skilldistillery.jets.entities;

public class Fighter extends Jet {

	public Fighter(String type, String model, int maxMph, int range, int price) {
		super(type, model, maxMph, range, price);
	}
	
	public void attack() {
		System.out.println("Locking on target.");
	}

}
