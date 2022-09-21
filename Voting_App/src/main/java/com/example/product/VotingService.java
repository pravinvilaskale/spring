package com.example.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VotingService {
	
	@Autowired
	public VotingRepository resp;

	public List<Voting> findall() {
		return resp.findAll();
	}
	
	
	public Voting get(Integer id) 
	{
		//System.out.println(resp.findById(id).get());
		return resp.findById(id).get();
	}

	public ResponseEntity<Object> save(Voting voting) {
		try 
		{
		resp.save(voting);
		return new ResponseEntity<>("Registered Successfully!",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("This username is already registered",HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> login(Voting voting) {
		// TODO Auto-generated method stub
		List<Voting> list = resp.findAll();
		int count=0;
		int index=0;
		//System.out.println(list.get(0).name);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).username.equals(voting.getUsername()))
			{
				count++;
				index=i;
			}
		}
		if(count>0)
		{
			if(list.get(index).password.equals(voting.getPassword()))
			{
				return new ResponseEntity<>(list.get(index),HttpStatus.OK);
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
	
	public boolean check(Integer id) {
		Voting voting = resp.findById(id).get();
		if(voting.getVote()==0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public ResponseEntity<?> admindetails() {
		
		List<Voting> list = resp.findAll();
		int[][] countarray = new int[5][2];
		int novote=0,candidate1=0,candidate2=0,candidate3=0,candidate4=0;
		
		for(int i=0;i<list.size();i++) 
		{
			if(list.get(i).vote==1)
			{
				candidate1++;
			}
			else if(list.get(i).vote==2)
			{
				candidate2++;
			}
			else if(list.get(i).vote==3)
			{
				candidate3++;
			}
			else if(list.get(i).vote==4)
			{
				candidate4++;
			}
			else 
			{
				novote++;
			}
		}
		for(int i=0;i<5;i++)
		{
			if(i==0)
			{
				countarray[0][0] = 0;
				countarray[0][1] = novote;
			}
			else 
			if(i==1) 
			{
				countarray[1][0] = 1;
				countarray[1][1] = candidate1;
			}
			else 
			if(i==2) 
			{
				countarray[2][0] = 2;
				countarray[2][1] = candidate2;
			}
			else 
			if(i==3) 
			{
				countarray[3][0] = 3;
				countarray[3][1] = candidate3;
			}
			else 
			if(i==4) 
			{
				countarray[4][0] = 4;
				countarray[4][1] = candidate4;
			}
			
		}
		//System.out.println(list.get(0).vote);
		return new ResponseEntity<>(countarray,HttpStatus.NOT_FOUND);
		
	}
	
	

}
