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

public class IssueLoanController implements Initializable {
	@FXML private TextField student_id;
	@FXML private TextField book_id;
	@FXML private TextField issue_date;
	@FXML private TextField return_date;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void issue(ActionEvent event) {
		BookManager.getInstance().issueBook(book_id.getText());
		BookLoanManager.getInstance().issueBookLoan(student_id.getText(), book_id.getText(), issue_date.getText(), return_date.getText());
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
