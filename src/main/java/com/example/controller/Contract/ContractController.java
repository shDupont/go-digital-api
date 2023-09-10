package com.example.controller.Contract;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Contract.Contract;
import com.example.repository.Contract.ContractRepository;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/")
public class ContractController {

	@Autowired
	private ContractRepository contractRepository;
	
	// get all contracts
	@GetMapping("/contracts")
	public List<Contract> getAllcontracts(){
		return contractRepository.findAll();
	}	
	public List<Contract> getAllcontracts(@RequestParam(name = "sortBy", required = false) String sortBy, @RequestParam(name = "order", required = false) String order){
		if(sortBy == null || order == null){
			return contractRepository.findAll();
		}
		Sort sort = Sort.by(order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
		return contractRepository.findAll(sort);
	}	
	
	// create contract rest api
	@PostMapping("/contracts")
	public Contract createContract(@RequestBody Contract contract) {
		return contractRepository.save(contract);
	}
	
	// get contract by id rest api
	@GetMapping("/contracts/{id}")
	public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
		Contract contract = contractRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contract not exist with id :" + id));
		return ResponseEntity.ok(contract);
	}
	
	// update contract rest api
	
	@PutMapping("/contracts/{id}")
	public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract contractDetails){
		Contract contract = contractRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contract not exist with id :" + id));
		
		contract.setExpiration(contractDetails.getExpiration());
		contract.setCnpj(contractDetails.getCnpj());
		contract.setInsurancePolicyId(contractDetails.getInsurancePolicyId());
        contract.setCustomerId(contractDetails.getCustomerId());
		
		Contract updatedContract = contractRepository.save(contract);
		return ResponseEntity.ok(updatedContract);
	}
	
	// delete contract rest api
	@DeleteMapping("/contracts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContract(@PathVariable Long id){
		Contract contract = contractRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contract not exist with id :" + id));
		
		contractRepository.delete(contract);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}