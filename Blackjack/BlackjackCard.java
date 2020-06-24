package Blackjack;

//这个class是要把一般的card 变成游戏中的card
//游戏的card 是普通card的一种 是subclass
public class BlackjackCard extends Card {
	// 不是card表面的value，是应用在游戏中的value
	int gameValue;

	public int getGameValue() {
		return gameValue;
	}

	public BlackjackCard(SUIT suit, int faceValue) {
		super(suit, faceValue);
		this.gameValue= faceValue;
		// 是根据规则把真的value变成游戏中的value
		// J Q K 都变成10
		if (this.gameValue > 10) {
			this.gameValue= 10;
		}
	}
}
