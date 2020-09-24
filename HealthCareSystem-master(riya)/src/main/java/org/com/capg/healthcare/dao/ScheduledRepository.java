package org.com.capg.healthcare.dao;

import java.util.List;

import org.com.capg.healthcare.entity.ScheduledAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduledRepository extends JpaRepository<ScheduledAppointments,String>{

	@Query(" select count(s.scheduledId)from ScheduledAppointments s where s.testCenter.testCenterId=:tid")
	public int getCountByCentreTest(@Param("tid") String diagnosisId);

	@Query("from ScheduledAppointments s where s.testCenter.testCenterId=:tid")
	public List<ScheduledAppointments> getSlots(@Param("tid") String diagnosisTestId);
}
