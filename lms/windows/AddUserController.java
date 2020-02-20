package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import lms.managers.UserManager;

public class AddUserController implements Initializable {
	@FXML private TextField login;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private RadioButton student;
	@FXML private RadioButton librarian;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addUser(ActionEvent event) {
		String role = "";
		if (student.isSelected()) role = "STUDENT";
		if (librarian.isSelected()) role = "LIBRARIAN";
		
		UserManager.getInstance().addUser(login.getText(), password.getText(), name.getText(), surname.getText(), role);
		((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
