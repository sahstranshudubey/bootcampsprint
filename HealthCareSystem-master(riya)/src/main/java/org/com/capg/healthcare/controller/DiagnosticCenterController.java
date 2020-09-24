package org.com.capg.healthcare.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.com.capg.healthcare.dto.SuccessMessage;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.service.DiagnosticCenterServiceImpl;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosticcenter")
@CrossOrigin("http://localhost:4200")
public class DiagnosticCenterController {
	
	@Autowired
	private DiagnosticCenterServiceImpl centerService;
	
	@GetMapping(TestConstants.ADD_CENTER_URL)
	public SuccessMessage addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws NameAlreadyExistException{
		return new SuccessMessage(centerService.saveDiagnosticCenter(diagnosticCenter));
	}
	
	
	@GetMapping(TestConstants.DELETE_CENTER_URL)
	public SuccessMessage removeCenter(@PathVariable(value = "centerId") String centerId) throws CenterNotFoundException {

		return new SuccessMessage(centerService.removeDiagnosticCenter(centerId));
	}
	
	@GetMapping(TestConstants.VIEW_ALL_CENTERS_URL)
	public List<DiagnosticCenter> getAllCenters(String centerId) {

		return centerService.getAllCenters(centerId);

	}
	
	@GetMapping(TestConstants.VIEW_CENTER_BY_CENTERID_URL)
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenter(@PathVariable String centerId)throws CenterNotFoundException
	{
		return centerService.getCenterById(centerId);
	}
	
	

}

