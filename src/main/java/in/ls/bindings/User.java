package in.ls.bindings;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

	private Integer userId;
	
	@NotBlank
	@Size(min=4,message="username must be of 4 charachters")
	private String name;

	@Email(message="Email address is not valid")
	private String email;
	
	@Size(min=3,max=10,message="Password should be between 3 to 10")
	private String password;
	
	private String about;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public User(Integer userId, String name, String email, String password, String about) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
}
