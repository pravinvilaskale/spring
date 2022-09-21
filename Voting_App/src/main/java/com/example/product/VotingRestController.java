package com.example.product;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class VotingRestController {
	
	@Autowired
	public VotingService service;
	
	@GetMapping("/voting")
	public List<Voting> list() 
	{
		return service.findall();
	}
	
	@GetMapping("/voting/{id}")
	public ResponseEntity<Voting> get(@PathVariable Integer id)
	{
		try 
		{
			Voting voting = service.get(id);
			return new ResponseEntity<Voting>(voting,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<Voting>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/voting")
	public ResponseEntity<?> add(@RequestBody Voting voting)
	{
		return service.save(voting);
	}
	
	
	//Voting
	@PutMapping("/voting/{id}")
	public ResponseEntity<?> updateUser(@RequestBody Voting voting, @PathVariable Integer id)
	{
	try
	{
		boolean checkVote = service.check(id);
		if(checkVote) 
		{
			Voting existUser = service.get(id);
			existUser.setVote(voting.getVote());
			//System.out.println(existUser);
			service.save(existUser);
			return new ResponseEntity<Object>("Voted Successfully",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Object>("Already Voted",HttpStatus.NOT_FOUND);
		}
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Voting voting)
	{
		return service.login(voting);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<?> admindetails() 
	{
		return service.admindetails();
	}

}
