package Vending;

public enum Coin {
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

	private int denomination;

	// 一个类似于Constructor的东西 用在enumeration class
	private Coin(int denomination) {
		this.denomination= denomination;
	}

	public int getDenomination() {
		return denomination;
	}
}
