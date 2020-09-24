package org.com.capg.healthcare.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SlotDto {
	@JsonFormat(pattern="yyyy-M-d")
	@DateTimeFormat(pattern = "yyyy-M-d")
	private LocalDate slotDate;
	private String diagnosticTestId;
	private int noOfAppointments;
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getNoOfAppointments() {
		return noOfAppointments;
	}

	public void setNoOfAppointments(int noOfAppointments) {
		this.noOfAppointments = noOfAppointments;
	}

	public LocalDate getSlotDate() {
		return slotDate;
	}

	public String getDiagnosticTestId() {
		return diagnosticTestId;
	}

	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}

	public void setDiagnosticTestId(String diagnosticTestId) {
		this.diagnosticTestId = diagnosticTestId;
	}

}
