package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shoe {
	// 还是一堆牌 但是好几副的牌 52*n
	private List<BlackjackCard> cards;
	private int numberOfDecks;

	// Shoe的constructor
	public Shoe(int numberOfDecks) {
		this.numberOfDecks= numberOfDecks;
		createShoe();
		shuffle();
	}

	// 把几副牌的卡片都装进去
	private void createShoe() {
		this.cards= new ArrayList<BlackjackCard>();
		for (int decks= 0; decks < numberOfDecks; decks++ ) {
			Deck Deckcards= new Deck();
			for (BlackjackCard c : Deckcards.getCards()) {
				cards.add(c);
			}
		}
	}

	// 给卡片打乱顺序
	public void shuffle() {
		int cardCount= cards.size();
		Random r= new Random();
		for (int i= 0; i < cardCount; i++ ) {
			int index= r.nextInt(cardCount - i - 1);
			swap(i, index);
		}
	}

	public void swap(int i, int j) {
		BlackjackCard temp= cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}

	// 从大List中取牌 拿牌 就是发牌操作
	public BlackjackCard dealCard() {
		if (cards.size() == 0) {
			createShoe();
		}
		return cards.remove(0);
	}
}
