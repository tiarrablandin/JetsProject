package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Attack;
import com.skilldistillery.jets.entities.Board;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;
import com.skilldistillery.jets.entities.Passenger;

public class JetsApp {
	Scanner sc = new Scanner(System.in);
	AirField airField = new AirField();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.run();
	}

	private void run() {
		airField.assembleFleet("jets.txt");
		
		System.out.println("Please make a selection: \n");

		while (true) {
			System.out.println("\n             Menu              ");
			System.out.println("-------------------------------");
			System.out.println("1: List fleet");
			System.out.println("2: Fly all jets.");
			System.out.println("3: View fastest jet.");
			System.out.println("4: View jet with longest range.");
			System.out.println("5: Load all cargo jets.");
			System.out.println("6: Attack!");
			System.out.println("7: Add a jet to the fleet.");
			System.out.println("8: Remove a jet from the fleet.");
			System.out.println("9: Quit");
			int selection = sc.nextInt();

			if (selection == 1) {
				for (Jet jet : airField.getFleet()) {
					System.out.println(jet.toString());
				}
			}
			if (selection == 2) {
				for (Jet jet : airField.getFleet()) {
					System.out.println(jet.fly());
				}
			}
			if (selection == 3) {
				String fastest;
				System.out.println(airField.fastestJet() + "\n");
			}
			if (selection == 4) {
				String farthest;
				System.out.println(airField.farthestJet() + "\n");
			}
			if (selection == 5) {
				for (Jet jet : airField.getFleet()) {
					if (jet instanceof Passenger) {
						((Board) jet).board();
					}
				}
			}
			if (selection == 6) {
				for (Jet jet : airField.getFleet()) {
					if (jet instanceof Attack) {
						((Attack) jet).attack();
					}
				}
			}
			if (selection == 7) {
				while (true) {
					System.out.println("Please enter the type of jet: ");
					sc.nextLine();
					String type = sc.nextLine();
					System.out.println("Please enter the model: ");
					String model = sc.nextLine();
					System.out.println("Please enter the max speed: ");
					int maxMph = sc.nextInt();
					System.out.println("Please enter the range: ");
					int range = sc.nextInt();
					System.out.println("Please enter the price: ");
					int price = sc.nextInt();
					
					JetImpl newJet = new JetImpl(type, model, maxMph, range, price);
					airField.fleet.add(newJet);
					break;

				}
			}
//			if (selection == 8) {
//				while (true) {
//					System.out.println("Which jet would you like to remove: ");
//					
//					int = sc.nextLine();
//				}
//			}
			if (selection == 9) {
				System.out.println("Goodbye.");
				break;
			}

		}
	}

}
