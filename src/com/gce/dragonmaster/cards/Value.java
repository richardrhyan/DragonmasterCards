package com.gce.dragonmaster.cards;

/**
 * Card values for for Dragonmaster Game. Values include FOOL,
 * BARON, COUNT, DUKE, WIZARD, PRINCE(SS), QUEEN & KING. The DRAGON
 * suit should have a NULL value.
 * Note that the PRINCE value is a PRINCESS for DRAGONLORDS & DRUIDS. 
 * @author Richard Rhyan
  */
public enum Value {
	FOOL ("Fool"),
	BARON ("Baron"),
	COUNT ("Count"),
	DUKE ("Duke"),
	WIZARD ("Wizard"),
	PRINCE ("Prince"),
	QUEEN ("Queen"),
	KING ("King");
	
	private String name;
	
	private Value(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
