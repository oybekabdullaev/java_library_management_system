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

public class ModifyUserController implements Initializable{
	@FXML private TextField login;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private TextField role;
	private int id;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void modify(ActionEvent event) {
		UserManager.getInstance().modifyUser(login.getText(), password.getText(), name.getText(), surname.getText(), "" + id, role.getText());
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	public void setInfo(User user) {
		id = user.getId();
		login.setText(user.getLogin());
		password.setText(user.getPassword());
		name.setText(user.getName());
		surname.setText(user.getSurname());
		role.setText(user.getRole().toString());
	}
}
