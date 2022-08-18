package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerDB extends BaseDB implements Owner {
	private static final int MAX_TOWN = 100;
	private static final String SQL_QUERY = "SELECT animal.Hunger, animal.Id, animal.Name, animal.Species FROM Animal animal, Owner owner WHERE owner.Id = '%s' AND animal.OwnerId = owner.Id";
	private static final String SQL_RELATE = "UPDATE Animal SET ownerId = '%s' WHERE Id = '%s'";
	private static final String SQL_WRITE_OWNER = "INSERT INTO Owner (Id, Name, Town) VALUES ('%s', '%s', '%s')";
	
	private List<Animal> pets = new ArrayList<Animal>();
	private String town = null;
	
	protected OwnerDB(String name, String town) {
		this.name = validate(name, MAX_NAME);
		this.town = validate(town, MAX_TOWN);
		this.write(String.format(SQL_WRITE_OWNER, this.uuid.toString(), this.name, this.town));
	}
	
	@Override
	public void adoptPet(Animal animal) {
		write(String.format(SQL_RELATE, this.uuid.toString(), ((AnimalDB)animal).uuid.toString()));
	}

	@Override
	public List<Animal> getPets() {
		this.pets.clear();
		read(String.format(SQL_QUERY, this.uuid.toString()));
		return this.pets;
	}

	@Override
	public String getTown() {
		return this.town;
	}
	
	@Override
	public void process(ResultSet results) {
		try {
			while (results.next()) {
				int hunger = results.getInt("animal.Hunger");
				UUID uuid = UUID.fromString(results.getString("animal.Id"));
				String name = results.getString("animal.Name");
				String species = results.getString("animal.Species");
				
				if (species.equals("C")) {
					this.pets.add(Factory.loadedCat(uuid, name, hunger));
				} else if (species.equals("D")) {
					this.pets.add(Factory.loadedDog(uuid, name, hunger));
				}
			}
		} catch(Exception ex) {
			throw new RuntimeException("Failed to query pets", ex);
		}
	}
}