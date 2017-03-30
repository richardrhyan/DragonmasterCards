package com.gce.dragonmaster.cards;

/**
 * Suits for the Dragonmaster game. Suits include DRAGONLORDS, 
 * DRUIDS, NOMADS, & WARRIORS. The DRAGON is included for Advanced
 * and Exper games.
 * @author Richard Rhyan
 */
public enum Suit {
	DRAGONLORDS ("Dragonlords"),
	DRUIDS ("Druids"),
	NOMADS ("Nomads"),
	WARRIORS ("Warriors"),
	DRAGON("Dragon");
	
	private String name;
	
	private Suit(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
