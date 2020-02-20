package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.managers.BookLoanManager;
import lms.managers.BookManager;

public class ReturnBookController implements Initializable {
	@FXML private TextField student_id;
	@FXML private TextField book_id;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void returnBook(ActionEvent event) {
		BookManager.getInstance().returnBook(book_id.getText());
		BookLoanManager.getInstance().returnBook(student_id.getText(), book_id.getText());
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
