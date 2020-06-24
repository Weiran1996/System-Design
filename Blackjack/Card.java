package Blackjack;

public class Card {
	// 其实就是任何一张卡片都有value和suit而已
	private SUIT suit;
	public int faceValue;

	// 就是给每一张卡片赋值
	Card(SUIT suit, int faceValue) {
		this.suit= suit;
		this.faceValue= faceValue;
	}

	public SUIT getSuit() {
		return suit;
	}

	public int getFaceValue() {
		return faceValue;
	}
}
