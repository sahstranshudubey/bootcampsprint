package org.com.capg.healthcare.service;

import java.math.BigInteger;
import java.util.List;

import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.springframework.http.ResponseEntity;

public interface DiagnosticCenterService {

	public String saveDiagnosticCenter(DiagnosticCenter diagnosticCenter)throws NameAlreadyExistException;
	
	public String removeDiagnosticCenter(String centerId) throws CenterNotFoundException;
	
	public List<DiagnosticCenter> getAllCenters(String centerId);
	
	public ResponseEntity<DiagnosticCenter> getCenterById(String centerId) throws CenterNotFoundException;
}
