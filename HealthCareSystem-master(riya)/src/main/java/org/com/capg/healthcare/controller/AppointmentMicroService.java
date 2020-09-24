package org.com.capg.healthcare.controller;


import java.util.List;

import org.com.capg.healthcare.dto.AppointmentMessage;
import org.com.capg.healthcare.entity.Appointment;
import org.com.capg.healthcare.exception.AppointmentException;
import org.com.capg.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.com.capg.healthcare.util.*;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentMicroService {
	
	@Autowired
	private AppointmentService service;
	
	/**************************************************************************************************
	 * Method       getAppointment
	 * Description  To get list of all the appointments inserted in the database
	 * 
	 * Created By    sahstranshu dubey
	 * Created Date   26-August-2020
	 ***************************************************************************************************/
	
	
	@GetMapping(SlotConstants.VIEW_APMT_URL)
	public List<Appointment> getAppointment(@PathVariable("slotid") String slotId) throws AppointmentException{
		
		return service.getAppointments(slotId);
	}
	
	/***************************************************************************************************
	 * Method       bookAppointment
	 * Description  To add the appoinment and insert it in the database
	 * 
	 * Created By    sahstranshu dubey
	 * Created Date   26-Aug-2020
	 *****************************************************************************************************/
	
	
	@GetMapping(SlotConstants.BOOK_APPOINTMENT_URL)
	public AppointmentMessage bookAppointment(@PathVariable("slotid") String slotId,
									@PathVariable("userid") Long userId) throws AppointmentException{
		String msg=service.bookAppointment(slotId, userId);
		return new AppointmentMessage(msg);
	}
	
}
