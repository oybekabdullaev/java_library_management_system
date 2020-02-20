package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lms.constants.UserRole;
import lms.entities.User;
import lms.managers.UserManager;

public class LoginController implements Initializable {
	@FXML
	private Label errorLabel;

	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void handleClick(ActionEvent event) throws Exception {
		String login = usernameField.getText();
		String password = passwordField.getText();
		User user = UserManager.getInstance().login(login, password);

		if (user != null) {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			if (user.getRole() == UserRole.ADMIN) {
				root = loader.load(getClass().getResource("Admin.fxml").openStream());
				AdminController adminController = (AdminController) loader.getController();
				adminController.setInfo(user.getName(), user.getSurname());
			} else if (user.getRole() == UserRole.LIBRARIAN) {
				root = loader.load(getClass().getResource("Librarian.fxml").openStream());
				LibrarianController librarianController = (LibrarianController) loader.getController();
				librarianController.setInfo(user.getName(), user.getSurname());
			} else {
				root = loader.load(getClass().getResource("Student.fxml").openStream());
				StudentController studentController = (StudentController) loader.getController();
				studentController.setInfo(user.getId(), user.getName(), user.getSurname());
			}

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} else {
			errorLabel.setText("Login and password do not match");
		}
	}

}
