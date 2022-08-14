package com.academy.travelapp;

import java.util.Scanner;

public class TravelAppCli {
	public static void main(String[] args) {
		try (TravelAppDB db = new TravelAppDB(); ) {
			System.out.println("Travel App Database started!");
			try (TravelApp app = new TravelApp()) {
				System.out.println("Travel App connected to database!");
				
				app.write("CREATE TABLE IF NOT EXISTS floz_test(forename VARCHAR(100), surname VARCHAR(100))");
				app.write("INSERT INTO floz_test (forename, surname) VALUES ('Laurence', 'Martin')");
				app.write("INSERT INTO floz_test (forename, surname) VALUES ('Hello', 'World')");
				app.write("INSERT INTO floz_test (forename, surname) VALUES ('Jelly', 'Plate');");
				app.read("SELECT forename, surname FROM floz_test");
				
				System.out.println("Press any key to exit!");
				try (Scanner in = new Scanner(System.in)) {
					in.nextLine();
				}
			}
		}
	}
}