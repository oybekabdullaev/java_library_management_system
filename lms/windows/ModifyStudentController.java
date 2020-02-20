package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.entities.User;
import lms.managers.UserManager;

public class ModifyStudentController implements Initializable{
	@FXML private TextField login;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	private int id;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void modify(ActionEvent event) {
		UserManager.getInstance().modifyStudent(login.getText(), password.getText(), name.getText(), surname.getText(), "" + id);
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}

	public void setInfo(User student) {
		id = student.getId();
		login.setText(student.getLogin());
		password.setText(student.getPassword());
		name.setText(student.getName());
		surname.setText(student.getSurname());
	}
}
