package com.academy.travelapp;

import java.util.Scanner;

public class TravelAppCli {
	public static void main(String[] args) {
		try (TravelAppDB db = new TravelAppDB()) {
			System.out.println("Travel App Database started!");

			System.out.println("Creating database schema");
			try (TravelApp app = new TravelApp()) {
				app.write("CREATE TABLE Owner (Id CHAR(36), Name VARCHAR(100), Town VARCHAR(100), PRIMARY KEY(Id));");
				app.write("CREATE TABLE Animal (Hunger INT, Id CHAR(36), Name VARCHAR(100), OwnerId CHAR(36), Species CHAR(1), PRIMARY KEY(Id), FOREIGN KEY (OwnerId) REFERENCES Owner(Id));");	
			}
			
			System.out.println("Creating owners");
			Owner floz = Factory.createOwner("Floz", "Bridgnorth");
			Factory.createOwner("Maddy", "Manchester");
			
			System.out.println("Creating cats");
			Cat jess = Factory.createCat("Jess");
			Factory.createCat("Toby");
			Factory.createCat("Bella");
			
			System.out.println("Creating dogs");
			Dog milo = Factory.createDog("Milo");
			Dog spot = Factory.createDog("Spot");
			Factory.createDog("Rover");
			
			System.out.println("Adopting pets");
			floz.adoptPet(jess);
			floz.adoptPet(milo);
			floz.adoptPet(spot);
			
			System.out.println("Animal noises");
			jess.meow();
			milo.bark();
			
			System.out.println("");
			System.out.println("Floz's pets:");
			for (Animal animal : floz.getPets()) {
				System.out.println(animal.toString());
			}
			
			System.out.println("");
			System.out.println("Press enter to exit!");
			try (Scanner in = new Scanner(System.in)) {
				in.nextLine();
			}
		}
	}
}