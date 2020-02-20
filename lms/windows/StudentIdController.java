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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lms.entities.User;
import lms.managers.UserManager;

public class StudentIdController implements Initializable {
	@FXML
	Button cancel = new Button();
	@FXML
	Button modify = new Button();
	@FXML
	TextField studentId = new TextField();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void cancel(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}

	public void modify(ActionEvent event) throws IOException {
		String studentIdText = studentId.getText();
		User student = UserManager.getInstance().getStudent(studentIdText);
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root;
		root = loader.load(getClass().getResource("ModifyStudent.fxml").openStream());
		ModifyStudentController controller = (ModifyStudentController)loader.getController();
		controller.setInfo(student);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
