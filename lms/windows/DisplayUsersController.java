package lms.windows;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lms.constants.UserRole;
import lms.constants.UserStatus;
import lms.entities.User;
import lms.managers.UserManager;

public class DisplayUsersController implements Initializable {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private TableView<User> usersTable;
	@FXML
	private TableColumn<User, Integer> id;
	@FXML
	private TableColumn<User, String> login;
	@FXML
	private TableColumn<User, String> password;
	@FXML
	private TableColumn<User, UserRole> role;
	@FXML
	private TableColumn<User, String> name;
	@FXML
	private TableColumn<User, String> surname;
	@FXML
	private TableColumn<User, UserStatus> status;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initCol();
		usersTable.getItems().setAll(UserManager.getInstance().getUsers());
	}

	private void initCol() {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		login.setCellValueFactory(new PropertyValueFactory<>("login"));
		password.setCellValueFactory(new PropertyValueFactory<>("password"));
		role.setCellValueFactory(new PropertyValueFactory<>("role"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
	}
}
