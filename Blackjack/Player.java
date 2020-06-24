package Blackjack;

import java.util.ArrayList;

public class Player extends BasePlayer {
	private int bet;
	private int totalCash;

	public Player(Hand hand) {
		this.hands= new ArrayList<Hand>();
		this.hands.add(hand);
	}
}
