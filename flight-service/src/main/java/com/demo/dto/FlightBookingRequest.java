package com.demo.dto;

import com.demo.entity.PassengerInfo;
import com.demo.entity.PaymentInfo;

public class FlightBookingRequest {
	
	private PassengerInfo pasInfo;
	
	private PaymentInfo payInfo;

	public FlightBookingRequest(PassengerInfo pasInfo, PaymentInfo payInfo) {
		super();
		this.pasInfo = pasInfo;
		this.payInfo = payInfo;
	}

	public PassengerInfo getPasInfo() {
		return pasInfo;
	}

	public void setPasInfo(PassengerInfo pasInfo) {
		this.pasInfo = pasInfo;
	}

	public PaymentInfo getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PaymentInfo payInfo) {
		this.payInfo = payInfo;
	}

	@Override
	public String toString() {
		return "FlightBookingRequest [pasInfo=" + pasInfo + ", payInfo=" + payInfo + "]";
	}
	
	

}
