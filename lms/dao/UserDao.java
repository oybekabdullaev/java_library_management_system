package lms.dao;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lms.constants.UserRole;
import lms.constants.UserStatus;
import lms.entities.User;

public class UserDao {
	public ObservableList<User> getUsers() {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<User> list = FXCollections.observableArrayList();

			String query = "select * from users";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setLogin(rset.getString("login"));
				user.setPassword(rset.getString("password"));
				user.setRole(UserRole.valueOf(rset.getString("role")));
				user.setName(rset.getString("name"));
				user.setSurname(rset.getString("surname"));
				user.setStatus(UserStatus.valueOf(rset.getString("status")));
				list.add(user);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public User login(String login, String password) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {

			String query = "select * from users where login = '" + login + "' and password = '" + password + "';";
			ResultSet rset = stmt.executeQuery(query);

			if (rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setLogin(rset.getString("login"));
				user.setPassword(rset.getString("password"));
				user.setRole(UserRole.valueOf(rset.getString("role")));
				user.setName(rset.getString("name"));
				user.setSurname(rset.getString("surname"));
				user.setStatus(UserStatus.valueOf(rset.getString("status")));
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ObservableList<User> getStudents() {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			ObservableList<User> list = FXCollections.observableArrayList();

			String query = "select * from users where role='STUDENT'";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setLogin(rset.getString("login"));
				user.setPassword(rset.getString("password"));
				user.setRole(UserRole.valueOf(rset.getString("role")));
				user.setName(rset.getString("name"));
				user.setSurname(rset.getString("surname"));
				user.setStatus(UserStatus.valueOf(rset.getString("status")));
				list.add(user);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void addStudent(String login, String password, String name, String surname) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "insert into users (login, password, role, name, surname, status) values ('" + 
			login + "', '" + password + "', 'STUDENT', '" + name + "', '" + surname + "', 'ACTIVE');";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public User getStudent(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {

			String query = "select * from users where id=" + id + ";";
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setLogin(rset.getString("login"));
				user.setPassword(rset.getString("password"));
				user.setRole(UserRole.valueOf(rset.getString("role")));
				user.setName(rset.getString("name"));
				user.setSurname(rset.getString("surname"));
				user.setStatus(UserStatus.valueOf(rset.getString("status")));
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void modifyStudent(String login, String password, String name, String surname, String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "update users set login = '" + login + "', password = '" + password + "', name = '"
			+ name + "', surname = '" + surname + "' where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteStudent(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "delete from users where id = " + id + " and role = 'STUDENT';";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void blockStudent(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "update users set status = 'BLOCKED' where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void addUser(String login, String password, String name, String surname, String role) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "insert into users (login, password, role, name, surname, status) values ('" + 
			login + "', '" + password + "', '" + role + "', '" + name + "', '" + surname + "', 'ACTIVE');";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void modifyUser(String login, String password, String name, String surname, String id, String role) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "update users set login = '" + login + "', password = '" + password + "', name = '"
			+ name + "', surname = '" + surname + "', role = '" + role + "' where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteUser(String id) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false", "root", "oybek2000");
				Statement stmt = conn.createStatement();) {
			
			String query = "delete from users where id = " + id + ";";
			stmt.executeUpdate(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}