package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lms.entities.BookLoan;

public class BookLoanDao {
	public ObservableList<BookLoan> getBookLoans() {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<BookLoan> list = FXCollections.observableArrayList();

			String query = "select bl.id, s.name, surname, b.title, subject, author, ISBN, publishDate, bl.issue_date, bl.return_date from users s, books b, bookLoans bl where\r\n" + 
					"bl.student_id = s.id and bl.book_id = b.id;";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				BookLoan loan = new BookLoan();
				loan.setAuthor(rset.getString("author"));
				loan.setId(rset.getInt("id"));
				loan.setISBN(rset.getString("ISBN"));
				loan.setName(rset.getString("name"));
				loan.setSurname(rset.getString("surname"));
				loan.setPublishDate(rset.getString("publishDate"));
				loan.setSubject(rset.getString("subject"));
				loan.setTitle(rset.getString("title"));
				loan.setReturnDate(rset.getString("return_date"));
				loan.setIssueDate(rset.getString("issue_date"));
				
				list.add(loan);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ObservableList<BookLoan> getStudentBookLoans(int id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<BookLoan> list = FXCollections.observableArrayList();

			String query = "select bl.id, s.name, surname, b.title, subject, author, ISBN, publishDate, bl.issue_date, bl.return_date from users s, books b, bookLoans bl where\r\n" + 
					"bl.student_id = s.id and bl.book_id = b.id and bl.student_id = " + id + ";";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				BookLoan loan = new BookLoan();
				loan.setAuthor(rset.getString("author"));
				loan.setId(rset.getInt("id"));
				loan.setISBN(rset.getString("ISBN"));
				loan.setName(rset.getString("name"));
				loan.setSurname(rset.getString("surname"));
				loan.setPublishDate(rset.getString("publishDate"));
				loan.setSubject(rset.getString("subject"));
				loan.setTitle(rset.getString("title"));
				loan.setReturnDate(rset.getString("return_date"));
				loan.setIssueDate(rset.getString("issue_date"));
				
				list.add(loan);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void issueBookLoan(String student_id, String book_id, String issue_date, String return_date) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {

			String query = "insert into bookLoans (student_id, book_id, issue_date, return_date) values (" + 
			student_id + ", " + book_id + ", '" + issue_date + "', + '" + return_date + "');";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void returnBook(String student_id, String book_id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {

			String query = "delete from bookLoans where student_id = " + student_id + " and book_id = " + book_id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}