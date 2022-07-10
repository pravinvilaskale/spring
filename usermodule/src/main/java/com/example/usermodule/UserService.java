package com.example.usermodule;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll()
	{
		return repo.findAll();
	}
	
	public 	void save(User user) 
	{
		repo.save(user);
	}
	
	public User get(Integer id) 
	{
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) 
	{
		repo.deleteById(id);
	}

	public ResponseEntity<Object> login(User user) {
		// TODO Auto-generated method stub
		List<User> list = repo.findAll();
		int count=0;
		int index=0;
		//System.out.println(list.get(0).name);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).name.equals(user.getName()))
			{
				count++;
				index=i;
			}
		}
		if(count>0)
		{
			if(list.get(index).password.equals(user.getPassword()))
			{
				return new ResponseEntity<>("Login Successfully!",HttpStatus.OK);
			}
			else 
			{
				return new ResponseEntity<>("Wrong password",HttpStatus.NOT_FOUND);
			}
		}
		else 
		{
			return new ResponseEntity<>("Username not register",HttpStatus.NOT_FOUND);
		}
	}
	
}
