package com.academy.travelapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TravelAppTest {
    @Test
    public void shouldReadAndWrite() {
		try (TravelAppDB db = new TravelAppDB(); TravelApp app = new TravelApp()) {
			app.write("CREATE TABLE IF NOT EXISTS floz_test(forename VARCHAR(100), surname VARCHAR(100))");
			app.write("INSERT INTO floz_test (forename, surname) VALUES ('Laurence', 'Martin')");
			app.write("INSERT INTO floz_test (forename, surname) VALUES ('Hello', 'World')");
			app.write("INSERT INTO floz_test (forename, surname) VALUES ('Jelly', 'Plate');");
			app.read("SELECT forename, surname FROM floz_test");
	        assertTrue(true);
		}
    }
}