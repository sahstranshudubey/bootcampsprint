package org.com.capg.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.com.capg.healthcare.dto.SuccessMessage;
import org.com.capg.healthcare.entity.Test;
import org.com.capg.healthcare.entity.TestCenter;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.service.TestServiceImpl;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class TestController {

	@Autowired
	private TestServiceImpl testService;


	@GetMapping(TestConstants.ADD_TEST_URL)
	public SuccessMessage addTestIntoExistingDiagnosticCentre(@PathVariable(value = "tid") String testId,
			@PathVariable(value = "cid") String centerId) throws TestNotFoundException, CenterNotFoundException, NameAlreadyExistException
	{

		return new SuccessMessage(testService.addTestToCenter(centerId, testId));

	}

	@GetMapping(TestConstants.VIEW_TEST_BY_CENTER_URL)
	public List<TestCenter> viewTest(@PathVariable(value = "cid") String centerId) throws TestNotFoundException
	{
		
		
		return testService.viewTests(centerId);
		
	}
	
	@GetMapping(TestConstants.VIEW_CENTER_BY_TEST)
	public List<TestCenter> viewCenter(@PathVariable(value = "tid") String testId) throws CenterNotFoundException
	{
		
		
		return testService.viewCenter(testId);
		
	}
	
	
}