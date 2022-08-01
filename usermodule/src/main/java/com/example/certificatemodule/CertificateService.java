package com.example.certificatemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

	@Autowired
	private CertificateRepository repo;
	
	public List<Certificate> listAll()
	{
		return repo.findAll();
	}
	
	public 	void save(Certificate certificate) 
	{
		repo.save(certificate);
	}
	
	public Certificate get(Integer id) 
	{
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) 
	{
		repo.deleteById(id);
	}
	
}
