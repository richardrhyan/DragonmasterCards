package com.gce.dragonmaster.cards;

public enum GameLevel {
	BASIC ("Basic Game"),
	ADVANCED ("Advanced Game"),
	EXPERT ("Expert Game");
	
	private String name;
	
	private GameLevel(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean includeDragon() {
		return (this.equals(ADVANCED) || this.equals(EXPERT));
	}
}
