package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.entities.Book;
import lms.managers.BookManager;

public class ModifyBookController implements Initializable{
	@FXML private TextField title;
	@FXML private TextField subject;
	@FXML private TextField author;
	@FXML private TextField ISBN;
	@FXML private TextField publishDate;
	@FXML private TextField quantity;
	
	private int id;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void modify(ActionEvent event) {
		BookManager.getInstance().modifyBook(title.getText(), subject.getText(), author.getText(), ISBN.getText(), publishDate.getText(), quantity.getText(), "" + id);
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}

	public void setInfo(Book book) {
		this.id = book.getId();
		title.setText(book.getTitle());
		subject.setText(book.getSubject());
		author.setText(book.getAuthor());
		ISBN.setText(book.getISBN());
		publishDate.setText(book.getPublishDate());
		quantity.setText("" + book.getQuantity());
	}
}
