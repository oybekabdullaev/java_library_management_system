package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lms.entities.Book;

public class BookDao {
	public ObservableList<Book> getBooks() {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<Book> list = FXCollections.observableArrayList();

			String query = "select * from books";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				Book book = new Book();
				book.setId(rset.getInt("id"));
				book.setTitle(rset.getString("title"));
				book.setSubject(rset.getString("subject"));
				book.setAuthor(rset.getString("author"));
				book.setISBN(rset.getString("ISBN"));
				book.setPublishDate(rset.getString("publishDate"));
				book.setQuantity(rset.getInt("quantity"));
				
				list.add(book);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ObservableList<Book> getFilteredBooks(String filter, String filterText) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<Book> list = FXCollections.observableArrayList();

			String query = "select * from books where " + filter + " = '" + filterText + "';";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				Book book = new Book();
				book.setId(rset.getInt("id"));
				book.setTitle(rset.getString("title"));
				book.setSubject(rset.getString("subject"));
				book.setAuthor(rset.getString("author"));
				book.setISBN(rset.getString("ISBN"));
				book.setPublishDate(rset.getString("publishDate"));
				book.setQuantity(rset.getInt("quantity"));
				
				list.add(book);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void addBook(String title, String subject, String author, String ISBN, String publishDate, String quantity) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "insert into books (title, subject, author, ISBN, publishDate, quantity) values ('" + 
					title + "', '" + subject + "', '" + author + "', '" + ISBN + "', '" + publishDate + "', " + quantity + ");";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Book getBook(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {

			String query = "select * from books where id = " + id + ";";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				Book book = new Book();
				book.setId(rset.getInt("id"));
				book.setTitle(rset.getString("title"));
				book.setSubject(rset.getString("subject"));
				book.setAuthor(rset.getString("author"));
				book.setISBN(rset.getString("ISBN"));
				book.setPublishDate(rset.getString("publishDate"));
				book.setQuantity(rset.getInt("quantity"));
				return book;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void modifyBook(String title, String subject, String author, String ISBN, String publishDate, String quantity, String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "update books set title = '" + title + "',  subject = '" + subject +
				"', author = '" + author + "', ISBN = '" + ISBN + "', publishDate = '" + publishDate + "', quantity = " + quantity + 
				" where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteBook(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "delete from books where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void issueBook(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			Book book = getBook(id);
			int newQuantity = book.getQuantity() - 1;
			
			String query = "update books set quantity = " + newQuantity + " where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void returnBook(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			Book book = getBook(id);
			int newQuantity = book.getQuantity() + 1;
			
			String query = "update books set quantity = " + newQuantity + " where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}