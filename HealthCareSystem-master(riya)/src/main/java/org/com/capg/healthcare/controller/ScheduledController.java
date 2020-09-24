package org.com.capg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.com.capg.healthcare.dto.*;
import org.com.capg.healthcare.entity.*;
import org.com.capg.healthcare.exception.*;
import org.com.capg.healthcare.service.*;
import org.com.capg.healthcare.util.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ScheduledController {

	@Autowired
	private ScheduledService slotService;
	
	@PostMapping(ScheduledConstants.ADD_SLOT_URL)
	public SlotMessage addSlot(@RequestBody SlotDto slotDto) throws ScheduledException {
		
		String res =slotService.addSlot(slotDto);
		return new SlotMessage(res);
	}
	
	
	@GetMapping(ScheduledConstants.VIEW_SLOT_URL)
	public List<ScheduledAppointments> viewSlot(@PathVariable("tid") String testId) throws ScheduledException {
		
		
		return slotService.getSlot(testId);
	}
}
