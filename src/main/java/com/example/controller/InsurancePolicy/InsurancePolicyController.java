package com.example.controller.InsurancePolicy;

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
import com.example.model.InsurancePolicy.InsurancePolicy;
import com.example.repository.InsurancePolicy.InsurancePolicyRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	// get all insurancePolicies
	@GetMapping("/insurancePolicies")
	public List<InsurancePolicy> getAllInsurancePolicy(){
		return insurancePolicyRepository.findAll();
	}		
	
	// create insurancePolicy rest api
	@PostMapping("/insurancePolicies")
	public InsurancePolicy createInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}
	
	// get insurancePolicy by id rest api
	@GetMapping("/insurancePolicies/{id}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id) {
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy not exist with id :" + id));
		return ResponseEntity.ok(insurancePolicy);
	}
	
	// update insurancePolicy rest api
	
	@PutMapping("/insurancePolicies/{id}")
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy insurancePolicyDetails){
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy not exist with id :" + id));
		
		insurancePolicy.setPolicyType(insurancePolicyDetails.getPolicyType());
		insurancePolicy.setContractId(insurancePolicyDetails.getContractId());
		insurancePolicy.setInsuranceCompanyId(insurancePolicyDetails.getInsuranceCompanyId());
        insurancePolicy.setInsuredObjectId(insurancePolicyDetails.getInsuredObjectId());
		
		InsurancePolicy updatedInsurancePolicy = insurancePolicyRepository.save(insurancePolicy);
		return ResponseEntity.ok(updatedInsurancePolicy);
	}
	
	// delete insurancePolicy rest api
	@DeleteMapping("/insurancePolicies/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInsurancePolicy(@PathVariable Long id){
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InsurancePolicy not exist with id :" + id));
		
		insurancePolicyRepository.delete(insurancePolicy);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}