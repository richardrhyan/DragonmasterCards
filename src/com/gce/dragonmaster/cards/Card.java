package com.gce.dragonmaster.cards;

import java.io.Serializable;

/**
 * An object of type card represents a playing card from the 
 * Dragonmaster deck, including a dragon. The card has a suit, which 
 * can be Dragonlords, Druids, Nomads, Warriors, or the Dragon. A 
 * Dragonlords, Druid, Nomad, or Warrior is assigned a value of
 * Fool, Baron, Count, Duke, Wizard, Prince(ss), Queen, King. A
 * Dragon does not have a value. 
 */
public class Card  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The cards suit, one of the enum Suit. The suit cannot 
	 * be changed after the card is constructed.
	 */
	private final Suit suit;
	
	/** 
	 * The cards value. For a normal card, this is one of the values
	 * Fool through King. For a dragon, the value 
	 * can be anything. The value cannot be changed after the card
	 * is constructed   
	 */
	private final Value value;
	
	/**
	 * Creates a card with a specified suit and value.
    * @param theValue the value of the new card. This must be one of the enum values
    * Value.FOOL, Value.BARON, Value.COUNT, Value.DUKE, Value.WIZARD, Value.PRINCE,
    * Value.QUEEN, or Value.KING. 
    * @param theSuit the suit of the new card.  This must be one of the enum values
    * Suit.DRAGONLORDS, Card.DRUIDS, Suit.NOMADS, Suit.WARRIORS, or Suit.DRAGON.
    * @throws IllegalArgumentException if the parameter values are not in the
    * permissible ranges
	 *
	 */
	public Card(Value theValue, Suit theSuit) {
		if (!theSuit.equals(Suit.DRAGON) && (theValue == null))
			throw new IllegalArgumentException("Illegal playing card value.");
		value = theValue;
		suit = theSuit;
	}
	
	/**
	 * Returns the suite of the card.
	 * @return the suit of enum Suit
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * Return the value of this card.
	 * @return the value, which is a value of 1 through 13 inclusive for 
	 * a regular card, and which can be any value for a jokersd 
	 */
	public Value getValue() {
		return value;
	}
	
	/**
	 * Returns the String representatio of the card's Suit.
	 * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
    * or "Joker".
	 */
	public String getSuitAsString() {
		return suit.toString();
	}
	
	/**
	    * Returns a String representation of the card's value.
	    * @return for a regular card, one of the strings "Ace", "2",
	    * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the 
	    * string is always numerical.
	    */
	public String getValueAsString() {
		if (suit.equals(Suit.DRAGON))
			return "";
		
		else
			return value.toString();
	}
	
	@Override
	public String toString() {
		if (suit.equals(Suit.DRAGON))
			return suit.toString();
		
		/* 
		 * Dragonlords and Druids have Princess instead of prince. 
		 */
		String princeExtension = "";
		if (
				(value.equals(Value.PRINCE)) && 
				((suit.equals(Suit.DRAGONLORDS)) ||(suit.equals(Suit.DRUIDS)))
				)
			princeExtension = "ss";
		
		return getValueAsString() + princeExtension + " of " + getSuitAsString();
	}
	
	public boolean equals(Card c) {
		return this.getSuit().equals(c.getSuit()) &&
				this.getValue().equals(c.getValue());
	}
}
