package com.academy.travelapp;

import java.util.UUID;

public class CatDB extends AnimalDB implements Cat {	
	protected CatDB(String name) {
		this.name = validate(name, MAX_NAME);
		this.write(String.format(SQL_WRITE, this.hunger, this.uuid.toString(), this.name, "C"));
	}
	
	protected CatDB(UUID uuid, String name, int hunger) {
		this.uuid = uuid;
		this.name = name;
		this.hunger = hunger;
	}

	@Override
	public void meow() {
		exerts(20);
		this.write(String.format(SQL_UPDATE, this.hunger, this.uuid.toString()));
	}
	
	@Override
	public String toString() {
		return "\nCat:\n"+super.toString();
	}
}