package com.example.usermodule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	// RESTful API methods for Retrieval operations
	@GetMapping("/users")
	public List<User> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
		try 
		{
			User user = service.get(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e) 
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API method for Create operation
	@PostMapping("/users")
	public void addNewUser(@RequestBody User user)
	{
		service.save(user);
	}
	
	// RESTful API method for Update operation
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id)
	{
	try
	{
		User existUser = service.get(id);
		user.setId(existUser.getId());
		service.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	// RESTful API method for Delete operation
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id)
	{
	service.delete(id);
	}
	
	//RESTful API method for login operation
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) 
	{
		return service.login(user);
	}
	
	//RESTful API method for logout operation
	@GetMapping("/logout")
	public ResponseEntity<?> logout() 
	{
		return new ResponseEntity<>("Logout",HttpStatus.OK);
	}
}
