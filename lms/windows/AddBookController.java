package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.managers.BookManager;

public class AddBookController implements Initializable {
	@FXML private TextField title;
	@FXML private TextField subject;
	@FXML private TextField author;
	@FXML private TextField ISBN;
	@FXML private TextField publishDate;
	@FXML private TextField quantity;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void addBook(ActionEvent event) {
		BookManager manager = BookManager.getInstance();
		String titleText = title.getText();
		String subjectText = subject.getText();
		String authorText = author.getText();
		String ISBNText = ISBN.getText();
		String publishDateText = publishDate.getText();
		String quantityText = quantity.getText();
		manager.addBook(titleText, subjectText, authorText, ISBNText, publishDateText, quantityText);
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
