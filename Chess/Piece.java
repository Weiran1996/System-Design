package Chess;

//The basic building block of the system, 
//every piece will be placed on a spot. 
//Piece class is an abstract class. The extended classes 
//(Pawn, King, Queen, Rook, Knight, Bishop) 
//implements the abstracted operations.
//这个是为了后续各种不同的棋子来extend的
public abstract class Piece {
	// 当前棋子还在不在场 是两方哪一方的棋子
	private boolean killed= false;
	private boolean white= false;

	public Piece(boolean white) {
		this.setWhite(white);
	}

	public boolean isWhite() {
		return this.white == true;
	}

	public void setWhite(boolean white) {
		this.white= white;
	}

	public boolean isKilled() {
		return this.killed == true;
	}

	public void setKilled(boolean killed) {
		this.killed= killed;
	}

	public abstract boolean canMove(Board board,
		Spot start, Spot end);
}
