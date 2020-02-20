package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.managers.UserManager;

public class AddStudentController implements Initializable {
	@FXML private TextField login;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addStudent(ActionEvent event) {
		UserManager.getInstance().addStudent(login.getText(), password.getText(), name.getText(), surname.getText());
		((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
