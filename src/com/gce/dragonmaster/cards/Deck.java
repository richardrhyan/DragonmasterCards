/* 
 * http://math.hws.edu/javanotes/c5/s4.html
 * http://math.hws.edu/javanotes/source/chapter5/Deck.java
 */

package com.gce.dragonmaster.cards;

/**
 *  An object of type Deck represents a deck of playing cards.  The deck
 *  is a regular poker deck that contains 52 regular cards and that can
 *  also optionally include two Jokers.
 */
public class Deck {

	/**
	 * an array of 52 cards (plus optional jokers).
	 */
	private Card[] deck;
	
	/**
	 * Keeps track of the number of cards hat have been dealt from 
	 * the deck so far. 
	 */
	private int cardsUsed;
	
    /**
     * Constructs a poker deck of playing cards, The deck contains
     * the usual 52 cards and can optionally contain two Jokers
     * in addition, for a total of 54 cards.   Initially the cards
     * are in a sorted order.  The shuffle() method can be called to
     * randomize the order.
     * @param includeJokers if true, two Jokers are included in the deck; if false,
     * there are no Jokers in the deck.
     */
	public Deck(int players, boolean includeDragon) {
		if (players < 3 || players > 4) 
			throw new IllegalArgumentException("Players must be 3 or 4");
		
		int deckSize = 8 * players;
		
		if (includeDragon)
			deckSize += 1;
		
		deck = new Card[deckSize];
		
		int cardCt = 0; // How many cards have been created so far
		for (Suit suit : Suit.values())
			if (!suit.equals(Suit.DRAGON))
				for (Value value : Value.values()) {
					if ((players == 4) || (!value.equals(Value.FOOL) && !value.equals(Value.BARON))) 
						deck[cardCt++] = new Card(value, suit);

					}
		if (includeDragon)
			deck[deckSize - 1] = new Card(null, Suit.DRAGON);
		
		cardsUsed = 0;
	}
	
	/**
	 * Put all the used cards back into the deck, 
	 * and shuffle it into a random order.
	 */
	public void shuffle() {
		for (int i = deck.length-1; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}
	
	/**
	 * As cards ae dealt from the deck, the number of cards left 
	 * decreases. This function returns the number of cards that 
	 * are still in the deck. The return value would be
     * 52 or 54 (depending on whether the deck includes Jokers)
     * when the deck is first created or after the deck has been
     * shuffled.  It decreases by 1 each time the dealCard() method
     * is called.
	 * @return int
	 */
	public int cardsLeft() {
		return deck.length - cardsUsed;
	}
	
	/**
	 * Removes the next card from the deck and returns it. It is illegal
	 * to call this method if there are no more cards in the deck. You can
	 * check the number of cards remaining by calling the cardsLeft() function.
	 * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
	 */
	public Card dealCard() throws IllegalStateException {
		if (cardsUsed == deck.length)
			throw new IllegalStateException("No cards left in the deck.");
		return deck[++cardsUsed - 1];
		// Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.		
	}
}
