package com.example.placementmodule;
import java.util.List;
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

@CrossOrigin(origins = {"http://localhost:3000/","http://localhost:3000/placement/{id}"})
@RestController
public class PlacementController {

	@Autowired
	private PlacementService service;
	
	
	@GetMapping("/Placements")
	public List<Placement> list(){
		return service.listAll();
	}
	
//	Search specific record from database
	@GetMapping("/Placements/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id){
	try {
	Placement placement= service.get(id);
	return new ResponseEntity<Placement>(placement, HttpStatus.OK);
	}
	catch(Exception e) {
	return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
	}
	}
	
	//Create row in database
	@PostMapping("/Placements")
	public void add(@RequestBody Placement placement) {
		service.save(placement);
	}
	
	
	//Update record in database
	@PutMapping("/Placements/{id}")
	public ResponseEntity<?> updatePlacement(@RequestBody Placement placement,@PathVariable Integer id){
		try {
			Placement exitPlacement= service.get(id);
			
			service.save(placement);
			return new ResponseEntity<>(exitPlacement, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
	
	
	//Delete record
	@DeleteMapping("/Placements/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
	//Search specific record from database
		@GetMapping("/search/{id}")
		public ResponseEntity<Placement> search(@PathVariable Integer id){
			try {
				Placement placement= service.search(id);
				return new ResponseEntity<Placement>(placement,  HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping("/cancel/{id}")
		public ResponseEntity<Placement> cancel(@PathVariable Integer id){
			try {
				service.cancel(id);
				return new ResponseEntity<Placement>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
			}
		}
	
}
