package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	// 手里中有的牌
	private ArrayList<BlackjackCard> cards;

	// 上来就先发两张牌
	public Hand(BlackjackCard c1, BlackjackCard c2) {
		this.cards= new ArrayList<BlackjackCard>();
		this.cards.add(c1);
		this.cards.add(c2);
	}

	private List<Integer> getScores() {
		// totals就是手里牌 各种score的可能
		List<Integer> totals= new ArrayList();
		totals.add(0);

		for (BlackjackCard card : cards) {
			List<Integer> newTotals= new ArrayList();
			for (int score : totals) {
				newTotals.add(card.faceValue + score);
				if (card.faceValue == 1) {
					newTotals.add(11 + score);
				}
			}
			totals= newTotals;
		}
		return totals;
	}

	// 多抽一张牌
	public void addCard(BlackjackCard card) {
		cards.add(card);
	}

	// get highest score which is less than or equal to 21
	public int resolveScore() {
		// 拿出牌中各种可能性的score
		List<Integer> scores= getScores();
		int bestScore= 0;
		// 找到分数最大的牌
		for (int score : scores) {
			if (score <= 21 && score > bestScore) {
				bestScore= score;
			}
		}
		return bestScore;
	}
}
