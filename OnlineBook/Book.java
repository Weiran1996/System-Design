package OnlineBook;

public class Book {
	// 每一本书都会有对应的id
	// detail 其实就是书中的内容
	private int bookId;
	private String details;

	// 初始化book的编号和内容
	public Book(int id, String det) {
		bookId= id;
		details= det;
	}

	// 用来更新book编号？
	public void update() {}

	public int getID() {
		return bookId;
	}

	public void setID(int id) {
		bookId= id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details= details;
	}
}
