package DeckofCards;

import java.util.ArrayList;

public class Hand<T extends Card> {
	protected ArrayList<T> cards= new ArrayList<T>();

	// 为了计算21点用的method
	public int score() {
		int score= 0;
		for (T card : cards) {
			score+= card.value();
		}
		return score;
	}

	public void addCard(T card) {
		cards.add(card);
	}

	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}
