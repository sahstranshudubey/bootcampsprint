
package org.com.capg.healthcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.com.capg.healthcare.dao.AppointmentRepository;
import org.com.capg.healthcare.dao.ScheduledRepository;
import org.com.capg.healthcare.dao.UserRepository;
import org.com.capg.healthcare.entity.Appointment;
import org.com.capg.healthcare.entity.ScheduledAppointments;
import org.com.capg.healthcare.entity.User;
import org.com.capg.healthcare.exception.AppointmentException;
import org.com.capg.healthcare.util.SlotConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointDao;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private ScheduledRepository slotDao;

	/***************************************************************************************************
	 * Method getAppointment Description To implement the method which get list of
	 * the appointment
	 * 
	 * Created By sahstranshu dubey Created Date 28-Aug-2020
	 *****************************************************************************************************/

	@Override
	public List<Appointment> getAppointments(String slotId) throws AppointmentException {
		List<Appointment> applist = appointDao.getAppointments(slotId);
		if (applist.isEmpty())
			throw new AppointmentException(SlotConstants.NO_APPOINTMENT_FOUND);
		return applist;
	}

	/***************************************************************************************************
	 * Method bookAppointment Description To implement the method which book the
	 * appointment
	 * 
	 * Created By sahstranshu dubey Created Date 22-sept-2020
	 *****************************************************************************************************/

	@Override
	public String bookAppointment(String slotId, Long userId) throws AppointmentException {

		Optional<User> optUser = userDao.findById(userId);
		if (!optUser.isPresent())
			throw new AppointmentException(SlotConstants.USER_NOT_FOUND);

		Optional<ScheduledAppointments> optSlot = slotDao.findById(slotId);
		if (!optSlot.isPresent())
			throw new AppointmentException(SlotConstants.SLOT_NOT_AVAILABLE);

		User user = optUser.get();
		ScheduledAppointments slot = optSlot.get();

		if (slot.getAppointments() <= SlotConstants.NOT_AVAILABLE)
			throw new AppointmentException(SlotConstants.NO_APPOINTMENT);

		Appointment apmt = new Appointment();
		String apmtId = slot.getScheduledId() + user.getPhoneNo();

		apmt.setAppointmentId(apmtId);
		apmt.setUser(user);
		apmt.setScheduled(slot);
		apmt.setDateOfBooking(slot.getDateOfAppointment());

		appointDao.save(apmt);
		slot.setAppointments(slot.getAppointments() - SlotConstants.INCREMENT);
		slotDao.save(slot);
		return SlotConstants.APPOINTMENT_CREATED + apmtId;
	}
}
