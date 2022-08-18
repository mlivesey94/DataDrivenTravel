package com.academy.travelapp;

import java.util.List;

public interface Owner extends Base {
	public void adoptPet(Animal animal);
	public List<Animal> getPets();
	public String getTown();
}
