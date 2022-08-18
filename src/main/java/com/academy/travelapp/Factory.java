package com.academy.travelapp;

import java.util.UUID;

public class Factory {
	public static Cat createCat(String name) {
		return new CatDB(name);
	}
	
	public static Dog createDog(String name) {
		return new DogDB(name);
	}
	
	public static Owner createOwner(String name, String town) {
		return new OwnerDB(name, town);
	}
	
	public static Cat loadedCat(UUID uuid, String name, int hunger) {
		return new CatDB(uuid, name, hunger);
	}
	
	public static Dog loadedDog(UUID uuid, String name, int hunger) {
		return new DogDB(uuid, name, hunger);
	}
}