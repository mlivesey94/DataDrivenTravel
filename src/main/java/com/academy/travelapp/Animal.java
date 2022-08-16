package com.academy.travelapp;

public interface Animal extends Base {
	
	/**
	 * Returns hunger as a percentage
	 * @return
	 */
	public int howHungry();
	
	/**
	 * When fed the animal is 30% less hungry
	 */
	public void feeds();
}
