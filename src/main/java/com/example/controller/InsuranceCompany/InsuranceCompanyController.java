package com.example.controller.InsuranceCompany;

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
import com.example.model.InsuranceCompany.InsuranceCompany;
import com.example.repository.InsuranceCompany.InsuranceCompanyRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class InsuranceCompanyController {

	@Autowired
	private InsuranceCompanyRepository insuranceCompanyRepository;
	
	// get all insuranceCompanies
	@GetMapping("/insuranceCompanies")
	public List<InsuranceCompany> getAllInsuranceCompanies(){
		return insuranceCompanyRepository.findAll();
	}		
	
	// create insuranceCompany rest api
	@PostMapping("/insuranceCompanies")
	public InsuranceCompany createInsuranceCompany(@RequestBody InsuranceCompany insuranceCompany) {
		return insuranceCompanyRepository.save(insuranceCompany);
	}
	
	// get insuranceCompany by id rest api
	@GetMapping("/insuranceCompanies/{id}")
	public ResponseEntity<InsuranceCompany> getInsuranceCompanyById(@PathVariable Long id) {
		InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuranceCompany not exist with id :" + id));
		return ResponseEntity.ok(insuranceCompany);
	}
	
	// update insuranceCompany rest api
	
	@PutMapping("/insuranceCompanies/{id}")
	public ResponseEntity<InsuranceCompany> updateInsuranceCompany(@PathVariable Long id, @RequestBody InsuranceCompany insuranceCompanyDetails){
		InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuranceCompany not exist with id :" + id));
		
		insuranceCompany.setCnpj(insuranceCompanyDetails.getCnpj());
		insuranceCompany.setName(insuranceCompanyDetails.getName());
		insuranceCompany.setInsurancePolicyId(insuranceCompanyDetails.getInsurancePolicyId());
		
		InsuranceCompany updatedInsuranceCompany = insuranceCompanyRepository.save(insuranceCompany);
		return ResponseEntity.ok(updatedInsuranceCompany);
	}
	
	// delete insuranceCompany rest api
	@DeleteMapping("/insuranceCompanies/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInsuranceCompany(@PathVariable Long id){
		InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsuranceCompany not exist with id :" + id));
		
		insuranceCompanyRepository.delete(insuranceCompany);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}