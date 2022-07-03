package com.skilldistillery.jets.entities;

public interface Board {

	public default void board() { // This would not let me move forward unless I made it default or static. Ask why.
		System.out.println("You are cleared to come aboard the aircraft.");
	}
}
