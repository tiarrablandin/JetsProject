package com.skilldistillery.jets.entities;

public abstract class Jet {
	protected String type;
	protected String model;
	protected int maxMph;
	protected int range;
	protected int price;
	
	public Jet(String type, String model, int maxMph, int range, int price) {
		this.type = type;
		this.model = model;
		this.maxMph = maxMph;
		this.range = range;
		this.price = price;
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet Type: ").append(type).append(", Model: ").append(model).append(", Max MPH: ").append(maxMph)
				.append(", Range: ").append(range).append(", Price: ").append(price);
		return builder.toString();
	}

	public String fly() {
		return "Is flying " + model + " and will fly for " + (range / maxMph) + " hours";
	}
	
}

	
	
