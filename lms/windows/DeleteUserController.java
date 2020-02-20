package lms.windows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lms.managers.UserManager;

public class DeleteUserController implements Initializable {
	@FXML
	Button cancel = new Button();
	@FXML
	Button delete = new Button();
	@FXML
	TextField userId = new TextField();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	public void delete(ActionEvent event) throws IOException {
		UserManager.getInstance().deleteUser(userId.getText());
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}