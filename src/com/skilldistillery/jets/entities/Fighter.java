package com.skilldistillery.jets.entities;

public class Fighter extends Jet implements Attack {

	protected Fighter(String type, String model, int maxMph, int range, int price) {
		super(type, model, maxMph, range, price);
	}
	
}
