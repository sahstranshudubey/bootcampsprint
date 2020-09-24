package org.com.capg.healthcare.service;

import java.util.List;

import org.com.capg.healthcare.dto.*;
import org.com.capg.healthcare.entity.*;
import org.com.capg.healthcare.exception.*;

public interface ScheduledService {

	public String addSlot(SlotDto slotDto)throws ScheduledException;

	public List<ScheduledAppointments> getSlot(String testd)throws ScheduledException;
}
