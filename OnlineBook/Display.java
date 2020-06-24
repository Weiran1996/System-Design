package OnlineBook;

public class Display {

	// 用来把书给用户看的 肯定得有User和Book这两个Object
	private Book activeBook;
	private User activeUser;
	private int pageNumber= 0;

	// 就是来setup 新来的user
	public void displayUser(User user) {
		activeUser= user;
		refreshUsername();
	}

	// 来setup 书籍的信息
	public void displayBook(Book book) {
		pageNumber= 0;
		activeBook= book;

		refreshTitle();
		refreshDetails();
		refreshPage();
	}

	public void refreshUsername() {
		/* updates username display */
	}

	public void refreshTitle() {
		/* updates title display */
	}

	public void refreshDetails() {
		/* updates details display */
	}

	public void refreshPage() {
		/* updated page display */
	}

	public void turnPageForward() {
		pageNumber++ ;
		refreshPage();
	}

	public void turnPageBackward() {
		pageNumber-- ;
		refreshPage();
	}
}
