package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AirField {
	public List<Jet> fleet = new ArrayList<>();
	// I had to make this public, in private it would not let me use set. Ask why.


	public AirField() {}
	
	public void assembleFleet(String fileName) {
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			  String line;
			  String className;
			  String model;
			  int maxMph;
			  int range;
			  int price;
			  
			  while ((line = bufIn.readLine()) != null) {
				  String[] jetInfo = line.split(",");
				  className = jetInfo[0];
				  model = jetInfo[1];
				  maxMph = Integer.parseInt(jetInfo[2]);
				  range = Integer.parseInt(jetInfo[3]);
				  price = Integer.parseInt(jetInfo[4]);
				  
				  if(className.equals("Passenger")) {
					  fleet.add(new Passenger(className, model, maxMph, range, price));
				  }
				  else if(className.equals("Tanker")) {
					  fleet.add(new Tanker(className, model, maxMph, range, price));
				  }
				  else if(className.equals("Fighter")) {
					  fleet.add(new Fighter(className, model, maxMph, range, price));
				  }
				  else if(className.equals("Surveillance")) {
					  fleet.add(new Surveillance(className, model, maxMph, range, price));
				  }
				  else if(className.equals("Cargo")) {
					  fleet.add(new Cargo(className, model, maxMph, range, price));
				  }
				  
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
	}
	
	public Jet fastestJet() {
		Jet fastestJet = fleet.get(0);
		for(int i = 1; i < fleet.size(); i++) {
			if (fleet.get(i) != null) {
				if(fleet.get(i).maxMph > fastestJet.maxMph) {
					fastestJet = fleet.get(i);
				}
			}
		}
		return fastestJet;
	}
	
	public Jet farthestJet() {
		Jet farthestJet = fleet.get(0);
		for(int i = 1; i < fleet.size(); i++) {
			if (fleet.get(i) != null) {
				if(fleet.get(i).range > farthestJet.range) {
					farthestJet = fleet.get(i);
				}
			}
		}
		return farthestJet;
	}
	
	public List<Jet> getFleet() {
		return fleet;
	}
	
	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	
	@Override
	public String toString() {
		return "AirField fleet: " + fleet;
	}
	
}
