package com.example.controller.Sinister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Sinister.Sinister;
import com.example.repository.Sinister.SinisterRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SinisterController {

	@Autowired
	private SinisterRepository sinisterRepository;
	
	// get all sinisters
	@GetMapping("/sinisters")
	public List<Sinister> getAllInsuranceCompanies(){
		return sinisterRepository.findAll();
	}		
	
	// create sinister rest api
	@PostMapping("/sinisters")
	public Sinister createSinister(@RequestBody Sinister sinister) {
		return sinisterRepository.save(sinister);
	}
	
	// get sinister by id rest api
	@GetMapping("/sinisters/{id}")
	public ResponseEntity<Sinister> getSinisterById(@PathVariable Long id) {
		Sinister sinister = sinisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sinister not exist with id :" + id));
		return ResponseEntity.ok(sinister);
	}
	
	// update sinister rest api
	
	@PutMapping("/sinisters/{id}")
	public ResponseEntity<Sinister> updateSinister(@PathVariable Long id, @RequestBody Sinister sinisterDetails){
		Sinister sinister = sinisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sinister not exist with id :" + id));
		
		sinister.setOccurrence(sinisterDetails.getOccurrence());
		sinister.setInsurancePolicyId(sinisterDetails.getInsurancePolicyId());
		
		Sinister updatedSinister = sinisterRepository.save(sinister);
		return ResponseEntity.ok(updatedSinister);
	}
	
	// delete sinister rest api
	@DeleteMapping("/sinisters/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSinister(@PathVariable Long id){
		Sinister sinister = sinisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sinister not exist with id :" + id));
		
		sinisterRepository.delete(sinister);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}