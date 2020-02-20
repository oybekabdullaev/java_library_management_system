package lms.windows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LibrarianController implements Initializable {
	@FXML
	Label userNameField = new Label();
	@FXML
	Label userSurnameField = new Label();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void setInfo(String name, String surname) {
		userNameField.setText(name);
		userSurnameField.setText(surname);
	}
	
	public void handleLogout(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void displayStudents(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DisplayStudents.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void addStudent(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void modifyStudent(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("StudentId.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void deleteStudent(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DeleteStudent.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void displayBooks(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DisplayBooks.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void addBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void modifyBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("BookId.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void deleteBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DeleteBook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void viewBorrowedBooks(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("BorrowedBooks.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void issueBookLoan(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("IssueBookLoan.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void blockStudent(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("BlockStudent.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void returnBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("ReturnBook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
