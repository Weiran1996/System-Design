package Blackjack;

import java.util.List;

public class BasePlayer {
	private String id;
	private String password;
	private double balance;

	// 可能手里有两副牌一起玩？
	protected List<Hand> hands;

	public boolean resetPassword() {
		return true;
	}

	public List<Hand> getHands() {
		return hands;
	}

	public void addHand(Hand hand) {
		hands.add(hand);
	}

	public void removeHand(Hand hand) {
		hands.remove(hand);
	}
}
