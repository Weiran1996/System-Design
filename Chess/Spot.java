package Chess;

//Spot: A spot represents one block of the 8×8 grid 
//and an optional piece.
//想说的是象棋摆放的位置 
public class Spot {
	// piece是 这个位置上放了什么棋子
	private Piece piece;
	// 当前位置的坐标
	private int x;
	private int y;

	// Constructor 声明当前位置和棋子
	public Spot(int x, int y, Piece piece) {
		this.setPiece(piece);
		this.setX(x);
		this.setY(y);
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece p) {
		this.piece= p;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x= x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y= y;
	}
}
