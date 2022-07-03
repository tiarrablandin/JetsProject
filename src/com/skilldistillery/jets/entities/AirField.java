package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AirField {
	private List<Jet> fleet = new ArrayList<>();
	public Object setFleet = fleet;

	public AirField() {}
	
	public void assembleFleet(String fileName) {
		asmblFleet(fileName);
	}
	
	private void asmblFleet(String fileName) {
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
	
	public void fastestJet() {
		System.out.println(fastJet());
	}
	
	private Jet fastJet() {
		Jet fastJet = fleet.get(0);
		for(int i = 1; i < fleet.size(); i++) {
			if (fleet.get(i) != null) {
				if(fleet.get(i).maxMph > fastJet.maxMph) {
					fastJet = fleet.get(i);
				}
			}
		}
		return fastJet;
	}
	
	
	public void farthestJet() {
		System.out.println(farJet());
	}
	
	private Jet farJet() {
		Jet farJet = fleet.get(0);
		for(int i = 1; i < fleet.size(); i++) {
			if (fleet.get(i) != null) {
				if(fleet.get(i).range > farJet.range) {
					farJet = fleet.get(i);
				}
			}
		}
		return farJet;
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
