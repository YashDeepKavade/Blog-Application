package in.ls.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ls.bindings.ApiResponse;
import in.ls.bindings.User;
import in.ls.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User addUser = service.addUser(user);
		return new ResponseEntity<User>(addUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getByUserId(@PathVariable Integer userId){
		User userById = service.getUserById(userId);
		return new ResponseEntity<User>(userById,HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable Integer userId){
		User updateUser = service.updateUser(user, userId);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<ApiResponse> deleteByUserId(@PathVariable Integer userId){
		service.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted",true),HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = service.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	
}
