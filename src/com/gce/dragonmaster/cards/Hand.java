/*
 * http://math.hws.edu/javanotes/c5/s4.html
 * http://math.hws.edu/javanotes/source/chapter5/Hand.java
 */

package com.gce.dragonmaster.cards;

import java.io.Serializable;
import java.util.ArrayList;

public class Hand implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> hand; // The cards in the hand.
	
	/**
	 * Constructor. Create a Hand Object that is initially empty.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Discard all cards from the hand, manking the hand empty.
	 */
	public void clear() {
		hand.clear();
	}
	
    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param c the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */

	public void addCard(Card c) {
		if (c==null)
			throw new NullPointerException("Can't add a null card to a hand.");
		hand.add(c);
	}
	
	public void addCards(Hand h) {
		if (h==null)
			throw new NullPointerException("Can't add a null hand to a hand.");
		for (int i = h.getSize() - 1; i >= 0; i--) {
			hand.add(h.getCard(i));
		}
		h = new Hand();
	}
	
    /** Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
	public void removeCard(Card c) {
		int index = -1;
		for (int i = 0; i < hand.size(); i++)
			if (hand.get(i).equals(c))
				index = i;
		removeCard(index);
	}
	
	/**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
	public void removeCard(int position) {
		if (position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		hand.remove(position);
	}
	
	/**
	 * Return the number of cards in the hand.
	 */
	public int getSize() {
		return hand.size();
	}
	
    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        return hand.get(position);
    }

	
	/**
	 * Sorts the cards in the hand so that the cards of the same 
	 * suit are grouped together, and within a suit the cards
	 * are sorted by value. Note that aces are considered to 
	 * have the lowest value, 1.
	 */
	public void sortBySuit() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int pos = 0; // position of minimal card
			Card c = hand.get(0); // minimal card
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
				if ( 
						(c1.getSuit().compareTo(c.getSuit()) < 0) 
						|| 
						(c1.getSuit().equals(c.getSuit()) && c1.getValue().compareTo(c.getValue()) < 0) 
						) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}
	
    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by suit.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( 
                		(c1.getSuit().equals(Suit.DRAGON)) ||
                		(c1.getValue().compareTo(c.getValue()) < 0) ||
                        (c1.getValue().equals(c.getValue()) && c1.getSuit().compareTo(c.getSuit()) < 0))
                {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
    
    /**
     * Returns true if the hand has at least one card that has the suit, or if
     * the suit passed is null.
     */
    public boolean contains(Suit suit) {
    	if (suit == null)
    		return true;
    	
    	for (Card c : hand)
    		if (c.getSuit().equals(suit))
    			return true;
    	
    	return false;    				
    }
    
    public String toString() {
    	String s = ""; 
    	for (Card c : hand) {
    		if (s != "") 
    			s += ", ";
    		s += c; 
    	}
    	return s;
    }
}