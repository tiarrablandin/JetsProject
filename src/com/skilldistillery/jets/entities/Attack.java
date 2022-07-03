package com.skilldistillery.jets.entities;

public interface Attack {
	
	public default void attack() { // This would not let me move forward unless I made it default or static. Ask why.
		System.out.println("Locking on target.");
	}

}
