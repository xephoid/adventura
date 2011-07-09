package com.ionmarkgames.aventura.model;

public enum StoryDirection {
	N("North"),
	S("South"),
	E("East"),
	W("West"),
	NE("North East"),
	NW("North West"),
	SE("South East"),
	SW("South West");
	
	private String description;
	
	private StoryDirection(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
