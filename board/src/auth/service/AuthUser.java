package auth.service;

public class AuthUser {
	
	private String id;
	private String name;
	
	public AuthUser(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
