package com.paulmalland.model;

import org.hibernate.validator.constraints.Range;

public class Goal {

	/**
	 * the Range annotion allow us to specify what's a valid value for minutes
	 * we still need to say to our controller that we whant a valid goal with valid minutes
	 */
	@Range(min = 1, max = 120)
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
