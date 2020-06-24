package Blackjack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Deck {
	// 每一个Deck中就是有52张牌
	private List<BlackjackCard> cards;
	private Date creationDate;

	// Constructor就是用来初始化这些牌 把他们存好的
	public Deck() {
		this.creationDate= new Date();
		this.cards= new ArrayList<BlackjackCard>();
		for (int value= 1; value <= 13; value++ ) {
			for (SUIT suit : SUIT.values()) {
				this.cards.add(new BlackjackCard(suit, value));
			}
		}
	}

	// 返回整理好的牌
	public List<BlackjackCard> getCards() {
		return cards;
	}
}
