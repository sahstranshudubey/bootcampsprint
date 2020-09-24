package org.com.capg.healthcare.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.com.capg.healthcare.dao.DiagnosticCenterRepository;
import org.com.capg.healthcare.dao.TestRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.util.TestConstants;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {


	@Autowired
	DiagnosticCenterRepository centerRepo;
	
	@Autowired
	TestRepository testRepo;
	
	
	
	/******************************************************************************************
	-Function Name            :     saveDiagnosticCenter
	-Description              :     adding Center to the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Object
	-Return Type              :     added Center object
	-Throws                   :     CenterNameAlreadyExistException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-20
	*******************************************************************************************/
	
	@Override
	public String saveDiagnosticCenter(DiagnosticCenter diagnosticCenter)throws NameAlreadyExistException {
		Optional<DiagnosticCenter> findId=centerRepo.findById(diagnosticCenter.getCenterId());
		if(findId.isPresent()) {
			throw new NameAlreadyExistException(TestConstants.NAME_ALREADY_EXIST);
		}
		/*if(centerRepo.getByCenterName(diagnosticCenter.getCenterName())!=null) {
			throw new NameAlreadyExistException(TestConstants.NAME_ALREADY_EXIST);
		}*/
		centerRepo.save(diagnosticCenter);
		return TestConstants.CENTER_ADDED;
		
	}
	
	/********************************************************************************************
	-Function Name            :     deleteCenter
	-Description              :     delete Center from the Diagnostic Center Database Table
	-Input Parameters         :     Diagnostic Center Id
	-Return Type              :     String showing whether deleted or not
	-Throws                   :     CenterNotFoundException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     20-09-2020
	*******************************************************************************************/
	
	@Override
	public String removeDiagnosticCenter(String centerId) throws CenterNotFoundException
    {
	 Optional<DiagnosticCenter> findById = centerRepo.findById(centerId);
		if (findById.isPresent()) {
			centerRepo.deleteById(centerId);
			return TestConstants.CENTER_DELETED;
		} else {
			return TestConstants.CENTER_NOT_FOUND;
		}
    }
	

	/******************************************************************************************
	-Function Name            :     getAllCenters
	-Description              :     getting Centers from the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Id only
	-Return Type              :     Diagnostic Center object corresponding to the given Id
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-2020
	*********************************************************************************************/
	
	@Override
	public List<DiagnosticCenter> getAllCenters(String centerId){
    	return centerRepo.findAll();   	
    }
 
	
	/******************************************************************************************
	-Function Name            :     getCenterById
	-Description              :     getting Center from the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Id only
	-Return Type              :     Center object corresponding to the given Id
	-Throws                   :     CenterNotFoundException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-2020
	*********************************************************************************************/
	
	
	@Override
	public ResponseEntity<DiagnosticCenter> getCenterById(String centerId) throws CenterNotFoundException {
		DiagnosticCenter center=centerRepo.findById(centerId).
			   	 orElseThrow(() -> new CenterNotFoundException(TestConstants.CENTER_NOT_FOUND));
			    	return ResponseEntity.ok().body(center);
	}	
		

	
	
	
	
	
		
	
		
		
		

}
