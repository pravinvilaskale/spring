package com.example.placementmodule;

import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlacementService {


	@Autowired
	private PlacementRepository repository;
	
	public List<Placement> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Placement get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	public void save(Placement placement) {
		// TODO Auto-generated method stub
		System.out.println(placement);
		repository.save(placement);
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	public Placement search(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	public void cancel(Integer id) {
		// TODO Auto-generated method stub
	   repository.deleteById(id);;
	}
	
}
