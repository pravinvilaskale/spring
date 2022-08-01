package com.example.certificatemodule;

import java.util.List;
import java.util.NoSuchElementException;

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
	

@RestController
public class CertificateController {
	
	@Autowired
	private CertificateService service;
	// RESTful API methods for Retrieval operations
	@GetMapping("/certificates")
	public List<Certificate> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/certificates/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Integer id)
	{
		try 
		{
			Certificate certificate = service.get(id);
			return new ResponseEntity<Certificate>(certificate,HttpStatus.OK);
		}
		catch(NoSuchElementException e) 
		{
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API method for Create operation
	@PostMapping("/certificates")
	public void addNewCertificate(@RequestBody Certificate certificate)
	{
		service.save(certificate);
	}
	
	// RESTful API method for Update operation
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> updateCertificate(@RequestBody Certificate certificate, @PathVariable Integer id)
	{
	try
	{
		Certificate existCertificate = service.get(id);
		certificate.setId(existCertificate.getId());
		service.save(certificate);
		return new ResponseEntity<Certificate>(certificate,HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	// RESTful API method for Delete operation
	@DeleteMapping("/certificates/{id}")
	public void deleteCertificate(@PathVariable Integer id)
	{
	service.delete(id);
	}

}
