package OnlineBook;

public class OnlineReaderSystem {
	// 这个货是最全的了 谁都得有
	private Library library;
	private UserManager userManager;
	private Display display;

	private Book activeBook;
	private User activeUser;

	// 只初始化两个manager系统 和要用的Display
	public OnlineReaderSystem() {
		userManager= new UserManager();
		library= new Library();
		display= new Display();
	}

	public Library getLibrary() {
		return library;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public Display getDisplay() {
		return display;
	}

	public Book getActiveBook() {
		return activeBook;
	}

	public void setActiveBook(Book book) {
		display.displayBook(book);
		activeBook= book;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User user) {
		activeUser= user;
		display.displayUser(user);
	}
}
