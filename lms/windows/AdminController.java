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

public class AdminController implements Initializable {
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
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void displayUsers(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DisplayUsers.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void addUser(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void modifyUser(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("UserId.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void deleteUser(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("DeleteUser.fxml"));
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
}
