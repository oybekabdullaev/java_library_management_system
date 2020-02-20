package lms.constants;

public enum UserStatus {
	BLOCKED("blocked"), ACTIVE("active");

	private UserStatus(String status) {
		this.status = status;
	}

	private String status;

	public String getStatus() {
		return status;
	}
}
