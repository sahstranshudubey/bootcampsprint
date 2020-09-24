package org.com.capg.healthcare.dao;

import java.util.List;

import org.com.capg.healthcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>
{
	@Query("from Appointment a where a.scheduled.scheduledId=:slotId")
	public List<Appointment> getAppointments(@Param("slotId") String testSlotId);
	

}
