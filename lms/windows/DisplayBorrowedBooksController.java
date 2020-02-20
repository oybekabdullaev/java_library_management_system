package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lms.entities.BookLoan;
import lms.managers.BookLoanManager;

public class DisplayBorrowedBooksController implements Initializable {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private TableView<BookLoan> bookLoansTable;
	@FXML
	private TableColumn<BookLoan, Integer> id;
	@FXML
	private TableColumn<BookLoan, String> name;
	@FXML
	private TableColumn<BookLoan, String> surname;
	@FXML
	private TableColumn<BookLoan, String> title;
	@FXML
	private TableColumn<BookLoan, String> subject;
	@FXML
	private TableColumn<BookLoan, String> author;
	@FXML
	private TableColumn<BookLoan, String> ISBN;
	@FXML
	private TableColumn<BookLoan, String> publishDate;
	@FXML
	private TableColumn<BookLoan, String> issueDate;
	@FXML
	private TableColumn<BookLoan, String> returnDate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initCol();
	}
	
	public void fill(int id) {
		bookLoansTable.getItems().setAll(BookLoanManager.getInstance().getStudentBookLoans(id));
	}
	
	private void initCol() {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		publishDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
		issueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
		returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
	}	
}
