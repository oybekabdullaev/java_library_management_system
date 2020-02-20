package lms.managers;

import javafx.collections.ObservableList;
import lms.dao.BookLoanDao;
import lms.entities.BookLoan;

public class BookLoanManager {
	private static BookLoanManager instance = new BookLoanManager();
	private static BookLoanDao dao = new BookLoanDao();

	private BookLoanManager() {
	}

	public static BookLoanManager getInstance() {
		return instance;
	}

	public ObservableList<BookLoan> getBookLoans() {
		return dao.getBookLoans();
	}
	
	public ObservableList<BookLoan> getStudentBookLoans(int id) {
		return dao.getStudentBookLoans(id);
	}

	public void issueBookLoan(String student_id, String book_id, String issue_date, String return_date) {
		dao.issueBookLoan(student_id, book_id, issue_date, return_date);
	}
	
	public void returnBook(String student_id, String book_id) {
		dao.returnBook(student_id, book_id);
	}
}
