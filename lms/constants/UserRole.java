package lms.constants;

public enum UserRole {
	ADMIN("Administrator"), LIBRARIAN("Librarian"), STUDENT("Student");

	private UserRole(String role) {
		this.role = role;
	}

	private String role;

	public String getRole() {
		return role;
	}
}
