package com.cafe.x.domain.entities;

public enum TemperatureType {

	HOT("Hot"), COLD("Cold");

	private String name;

	private TemperatureType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
