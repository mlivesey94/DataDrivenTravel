package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.UUID;

public class BaseDB implements Base, Processor {
	protected static final int MAX_NAME = 100;
	protected static final int MAX_UUID = 36;
	
	protected UUID uuid;
	protected String name;

	@Override
	public UUID getId() {
		return this.uuid;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public void process(ResultSet results) {
		// Left for descendants to implement
	}
	
	protected BaseDB() {
		this.uuid = UUID.randomUUID();
	}
		
	protected void read(String query) {
		try (TravelApp app = new TravelApp()) {
			app.read(this, query);				
		}
	}
	
	protected void write(String query) {
		try (TravelApp app = new TravelApp()) {
			app.write(query);
		}
	}
	
	protected String validate(String value, int max) {
		if ((value == null) || (value.length() < 1)) {
			throw new RuntimeException("String is unspecified!");
		}
		
		if (value.length() > max) {
			throw new RuntimeException("String is too large!");
		}
		
		if (!value.matches("^[a-zA-Z0-9 ]*$")) {
			throw new RuntimeException("String can only be alphanumber with spaces!");
		}
		
		return value;
	}
}
