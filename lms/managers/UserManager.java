package lms.managers;

import javafx.collections.ObservableList;
import lms.constants.UserRole;
import lms.constants.UserStatus;
import lms.dao.UserDao;
import lms.entities.User;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(int id, String login, String password, UserRole role, String name, String surname,
			UserStatus status) {
		User user = new User();
		user.setId(id);
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(role);
		user.setName(name);
		user.setSurname(surname);
		user.setStatus(status);
		return user;
	}

	public ObservableList<User> getUsers() {
		return dao.getUsers();
	}
	
	public ObservableList<User> getStudents() {
		return dao.getStudents();
	}
	
	public User login(String login, String password) {
		return dao.login(login, password);
	}
	
	public void addStudent(String login, String password, String name, String surname) {
		dao.addStudent(login, password, name, surname);
	}
	
	public User getStudent(String id) {
		return dao.getStudent(id);
	}

	public void modifyStudent(String login, String password, String name, String surname, String id) {
		dao.modifyStudent(login, password, name, surname, id);
	}

	public void deleteStudent(String id) {
		dao.deleteStudent(id);
	}
	
	public void blockStudent(String id) {
		dao.blockStudent(id);
	}
	
	public void addUser(String login, String password, String name, String surname, String role) {
		dao.addUser(login, password, name, surname, role);
	}
	
	public void modifyUser(String login, String password, String name, String surname, String id, String role) {
		dao.modifyUser(login, password, name, surname, id, role);
	}
	
	public void deleteUser(String id) {
		dao.deleteUser(id);
	}
}