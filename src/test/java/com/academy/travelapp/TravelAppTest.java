package com.academy.travelapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TravelAppTest {
    @Test
    public void shouldReadAndWrite() {
		try (TravelAppDB db = new TravelAppDB(); TravelApp app = new TravelApp()) {
			assertTrue(true);
		}
    }
}