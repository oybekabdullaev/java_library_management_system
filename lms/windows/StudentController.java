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

public class StudentController implements Initializable {
	@FXML
	Label userNameField = new Label();
	@FXML
	Label userSurnameField = new Label();
	
	private int id;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void setInfo(int id, String name, String surname) {
		this.id = id;
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

	public void displayAllBooks(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DisplayBooks.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void displayFilteredBooks(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("Filter.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void displayBorrowedBooks(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("DisplayBorrowedBooks.fxml").openStream());
		DisplayBorrowedBooksController controller = (DisplayBorrowedBooksController)loader.getController();
		controller.fill(this.id);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
