package com.academy.travelapp;

public class AnimalDB extends BaseDB implements Animal {
	protected static final String SQL_UPDATE = "UPDATE Animal SET Hunger = %d WHERE Id = '%s'";
	protected static final String SQL_WRITE = "INSERT INTO Animal (Hunger, Id, Name, OwnerId, Species) VALUES (%d, '%s', '%s', NULL, '%s');";
	
	protected int hunger = 0;
	
	protected AnimalDB() {
		
	}
	
	@Override
	public int howHungry() {
		return this.hunger;
	}

	@Override
	public void feeds() {
		this.hunger -= 30;
		if (this.hunger < 0) {
			throw new RuntimeException("Animal is sick!");
		}
		
		this.write(String.format(SQL_UPDATE, this.hunger, this.uuid.toString()));
	}
	
	protected void exerts(int energy) {
		this.hunger += energy;
		if (this.hunger > 100) {
			throw new RuntimeException("Animal has died of hunger!");
		}
	}
	
	public String toString() {
		return String.format(" - name: %s\n - hunger: %d", this.name, this.hunger);
	}
}