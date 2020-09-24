package org.com.capg.healthcare.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDto
{
	@JsonFormat(pattern = "dd-MM-yyyy")
		private LocalDate appointmentDate;
		
	private String testId;
	private String userId;
	private String centreId;
		
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}
		
		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public String getTestId() {
			return testId;
		}
		public void setTestId(String testId) {
			this.testId = testId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getCentreId() {
			return centreId;
		}
		public void setCentreId(String centreId) {
			this.centreId = centreId;
		}
		public AppointmentDto(LocalDate appointmentDate, String testId, String userId, String centreId) {
			super();
			this.appointmentDate = appointmentDate;
			this.testId = testId;
			this.userId = userId;
			this.centreId = centreId;
		}
		@Override
		public String toString() {
			return "AppointmentDto [appointmentDate=" + appointmentDate + ", testId=" + testId + ", userId=" + userId
					+ ", centreId=" + centreId + "]";
		}
		public AppointmentDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		


}

