package org.com.capg.healthcare.service;

import org.com.capg.healthcare.dao.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.com.capg.healthcare.dao.*;

import org.com.capg.healthcare.dto.*;
import org.com.capg.healthcare.entity.*;

import org.com.capg.healthcare.exception.*;
import org.com.capg.healthcare.util.*;
@Service
@Transactional
public class ScheduledServiceImpl implements ScheduledService {
	
	@Autowired
	private ScheduledRepository slotDao;
	
	@Autowired
	private TestCenterRepository diagnosisTestDao;

	public String addSlot(SlotDto slotDto) throws ScheduledException {
		// TODO Auto-generated method stub
		Optional<TestCenter> opt=diagnosisTestDao.findById(slotDto.getDiagnosticTestId());
		if(!opt.isPresent())
			throw new ScheduledException(ScheduledConstants.CENTRE_TEST_NOT_FOUND);
		TestCenter dTest=opt.get();
		int count=slotDao.getCountByCentreTest(slotDto.getDiagnosticTestId())+ScheduledConstants.INCREMENT;
		String slotId=slotDto.getDiagnosticTestId()+ScheduledConstants.EMPTY+count;
		
		ScheduledAppointments slot=new ScheduledAppointments();
		slot.setDateOfAppointment((slotDto.getSlotDate()));
		slot.setAppointments(slotDto.getNoOfAppointments());
		slot.setScheduledId(slotId);
		slot.setTestCost(slotDto.getAmount());
		slot.setTestCenter(dTest);
		slotDao.save(slot);
		return ScheduledConstants.SLOT_CREATED;
		
	}

	public List<ScheduledAppointments> getSlot(String testd) throws ScheduledException {
		// TODO Auto-generated method stub
		List<ScheduledAppointments> slots=slotDao.getSlots( testd);
		if(slots.isEmpty())
			throw new ScheduledException(ScheduledConstants.SLOT_NOT_AVAILABLE);
		slots=slots.stream().filter(s->s.getDateOfAppointment().isAfter(LocalDate.now()) 
				||s.getDateOfAppointment().isEqual(LocalDate.now())).collect(Collectors.toList());
		
		/*
		 * slots=slots.stream().filter(s->LocalDate.now().isAfter(s.getSlotDate())).
		 * collect(Collectors.toList());
		 */
		slots.sort((s1,s2)->s1.getDateOfAppointment().compareTo(s2.getDateOfAppointment()));
 		return slots;
		
		
	}
}
	/*@Override
	public String addSlot(SlotDto slotDto) throws SlotException{
		
		Optional<DiagnosisTest> opt=diagnosisTestDao.findById(slotDto.getDiagnosticTestId());
		if(!opt.isPresent())
			throw new SlotException(SlotConstants.CENTRE_TEST_NOT_FOUND);
		DiagnosisTest dTest=opt.get();
		int count=slotDao.getCountByCentreTest(slotDto.getDiagnosticTestId())+SlotConstants.INCREMENT;
		String slotId=slotDto.getDiagnosticTestId()+SlotConstants.EMPTY+count;
		
		CheckUpSlot slot=new CheckUpSlot();
		slot.setSlotDate(slotDto.getSlotDate());
		slot.setNumOfApp(slotDto.getNoOfAppointments());
		slot.setTestSlotId(slotId);
		slot.setAmt(slotDto.getAmount());
		slot.setDiagnosisTest(dTest);
		slotDao.save(slot);
		return SlotConstants.SLOT_CREATED;
	}

	@Override
	public List<CheckUpSlot> getSlot(String testId) throws SlotException {
		List<CheckUpSlot> slots=slotDao.getSlots(testId);
		if(slots.isEmpty())
			throw new SlotException(SlotConstants.SLOT_NOT_AVAILABLE);
		slots=slots.stream().filter(s->s.getSlotDate().isAfter(LocalDate.now()) 
				||s.getSlotDate().isEqual(LocalDate.now())).collect(Collectors.toList());
		
		/*
		 * slots=slots.stream().filter(s->LocalDate.now().isAfter(s.getSlotDate())).
		 * collect(Collectors.toList());
		 */
		/*slots.sort((s1,s2)->s1.getSlotDate().compareTo(s2.getSlotDate()));
 		return slots;
	}

}*/

