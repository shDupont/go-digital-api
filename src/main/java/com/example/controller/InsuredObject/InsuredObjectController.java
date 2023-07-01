package com.example.controller.InsuredObject;

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
import com.example.model.InsuredObject.InsuredObject;
import com.example.repository.InsuredObject.InsuredObjectRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class InsuredObjectController {

	@Autowired
	private InsuredObjectRepository insuredObjectRepository;
	
	// get all insuredObjects
	@GetMapping("/insuredObjects")
	public List<InsuredObject> getAllInsuranceCompanies(){
		return insuredObjectRepository.findAll();
	}		
	
	// create insuredObject rest api
	@PostMapping("/insuredObjects")
	public InsuredObject createInsuredObject(@RequestBody InsuredObject insuredObject) {
		return insuredObjectRepository.save(insuredObject);
	}
	
	// get insuredObject by id rest api
	@GetMapping("/insuredObjects/{id}")
	public ResponseEntity<InsuredObject> getInsuredObjectById(@PathVariable Long id) {
		InsuredObject insuredObject = insuredObjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuredObject not exist with id :" + id));
		return ResponseEntity.ok(insuredObject);
	}
	
	// update insuredObject rest api
	
	@PutMapping("/insuredObjects/{id}")
	public ResponseEntity<InsuredObject> updateInsuredObject(@PathVariable Long id, @RequestBody InsuredObject insuredObjectDetails){
		InsuredObject insuredObject = insuredObjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuredObject not exist with id :" + id));
		
		insuredObject.setInsurancePolicyId(insuredObjectDetails.getInsurancePolicyId());
		
		InsuredObject updatedInsuredObject = insuredObjectRepository.save(insuredObject);
		return ResponseEntity.ok(updatedInsuredObject);
	}
	
	// delete insuredObject rest api
	@DeleteMapping("/insuredObjects/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInsuredObject(@PathVariable Long id){
		InsuredObject insuredObject = insuredObjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuredObject not exist with id :" + id));
		
		insuredObjectRepository.delete(insuredObject);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}