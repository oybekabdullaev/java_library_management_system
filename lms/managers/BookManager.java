package lms.managers;

import javafx.collections.ObservableList;
import lms.dao.BookDao;
import lms.entities.Book;

public class BookManager {
	private static BookManager instance = new BookManager();
	private static BookDao dao = new BookDao();

	private BookManager() {
	}

	public static BookManager getInstance() {
		return instance;
	}

	public Book createBook(int id, String title, String subject, String author, String ISBN, String publishDate,
			int quantity) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setSubject(subject);
		book.setAuthor(author);
		book.setISBN(ISBN);
		book.setPublishDate(publishDate);
		book.setQuantity(quantity);
		return book;
	}

	public ObservableList<Book> getBooks() {
		return dao.getBooks();
	}
	
	public ObservableList<Book> getFilteredBooks(String filter, String filterText) {
		return dao.getFilteredBooks(filter, filterText);
	}
	
	public void addBook(String title, String subject, String author, String ISBN, String publishDate, String quantity) {
		dao.addBook(title, subject, author, ISBN, publishDate, quantity);
	}
	
	public Book getBook(String id) {
		return dao.getBook(id);
	}
	
	public void modifyBook(String title, String subject, String author, String ISBN, String publishDate, String quantity, String id) {
		dao.modifyBook(title, subject, author, ISBN, publishDate, quantity, id);
	}
	
	public void deleteBook(String id) {
		dao.deleteBook(id);
	}
	
	public void issueBook(String id) {
		dao.issueBook(id);
	}
	
	public void returnBook(String id) {
		dao.returnBook(id);
	}
}