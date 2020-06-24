package OnlineBook;

import java.util.HashMap;

//其实啊 这个Library 就是一个book manager而已
//就是为了 增减书籍 和书的信息
public class Library {
	// id和对应的书的object
	private HashMap<Integer, Book> books;

	// 就是用Book自己Constructor初始化 然后加到library的database中去
	public Book addBook(int id, String details) {
		if (books.containsKey(id)) { return null; }
		Book book= new Book(id, details);
		books.put(id, book);
		return book;
	}

//	public boolean remove(Book b) {
//		return remove(b.getID());
//	}

	// Given id 移除一个已经在库里的book
	public boolean remove(int id) {
		if (!books.containsKey(id)) { return false; }
		books.remove(id);
		return true;
	}

	// 找到对应的book 返回它的信息
	public Book find(int id) {
		return books.get(id);
	}
}
