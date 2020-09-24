package org.com.capg.healthcare.service;

import java.util.List;

import org.com.capg.healthcare.entity.Appointment;
import org.com.capg.healthcare.exception.AppointmentException;



/***************************************************************************************************
 * @author sahstranshu dubey
 * Description   It is service interface that provide the methods for adding new appointment , show all
 *                appointment and further implemented by service implementation 
 *    
 *version         1.0
 *Created Date    22-Sept-2020                
 * 
 ****************************************************************************************************/


public interface AppointmentService
{
	
	public List<Appointment>  getAppointments(String slotId)throws AppointmentException;
	
  
	public String bookAppointment(String slotId,Long userId)throws AppointmentException;
	
	
	
}
	



