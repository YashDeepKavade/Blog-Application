package in.ls.service;

import java.util.List;

import in.ls.bindings.User;

public interface UserService {

	public User addUser(User user);
	
	public User getUserById(Integer userId);
	
	public User updateUser(User user,Integer userId);
	
	public void deleteUser(Integer userId);
	
	public List<User> getAllUsers();
	
}
