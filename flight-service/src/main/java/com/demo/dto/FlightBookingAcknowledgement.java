package com.demo.dto;

import com.demo.entity.PassengerInfo;

public class FlightBookingAcknowledgement {
	
	private String status;
	
	private double totalFare;
	
	private String pnrNo;
	
	private PassengerInfo pasInfo;

	public FlightBookingAcknowledgement(String status, double totalFare, String pnrNo, PassengerInfo pasInfo) {
		super();
		this.status = status;
		this.totalFare = totalFare;
		this.pnrNo = pnrNo;
		this.pasInfo = pasInfo;
	}

	@Override
	public String toString() {
		return "FlightBookingAcknowledgement [status=" + status + ", totalFare=" + totalFare + ", pnrNo=" + pnrNo
				+ ", pasInfo=" + pasInfo + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public PassengerInfo getPasInfo() {
		return pasInfo;
	}

	public void setPasInfo(PassengerInfo pasInfo) {
		this.pasInfo = pasInfo;
	}

	public FlightBookingAcknowledgement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
