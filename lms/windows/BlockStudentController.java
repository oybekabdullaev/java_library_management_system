package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lms.managers.UserManager;

public class BlockStudentController implements Initializable{
	@FXML private TextField studentId;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void block(ActionEvent event) {
		UserManager.getInstance().blockStudent(studentId.getText());
		((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
