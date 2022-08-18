package com.academy.travelapp;

import java.util.UUID;

public class DogDB extends AnimalDB implements Dog {
	protected DogDB(String name) {
		this.name = validate(name, MAX_NAME);
		this.write(String.format(SQL_WRITE, this.hunger, this.uuid.toString(), this.name, "D"));
	}
	
	protected DogDB(UUID uuid, String name, int hunger) {
		this.uuid = uuid;
		this.name = name;
		this.hunger = hunger;
	}

	@Override
	public void bark() {
		exerts(10);
		this.write(String.format(SQL_UPDATE, this.hunger, this.uuid.toString()));
	}
	
	@Override
	public String toString() {
		return "\nDog:\n"+super.toString();
	}
}