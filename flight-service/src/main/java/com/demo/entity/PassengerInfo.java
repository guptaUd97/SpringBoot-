package com.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
//@AllArgsConstructor
//@NoArgsConstructor


@Entity
@Table(name="PASSENGER_INFO")
@JsonInclude(value = Include.NON_NULL)
public class PassengerInfo {
	
	@Id
	@GeneratedValue
	private Long pId;
	
	private String name;
	
	private String email;
	
	private String source;
	
	private String destination;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-mm-yyyy" )
	private Date travelDate;
	
	private String pickupTime;
	
	private String arrivalTime;
	
	private double fare;

	public PassengerInfo(Long pId, String name, String email, String source, String destination, Date travelDate,
			String pickupTime, String arrivalTime, double fare) {
		super();
		this.pId = pId;
		this.name = name;
		this.email = email;
		this.source = source;
		Destination = destination;
		this.travelDate = travelDate;
		this.pickupTime = pickupTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public PassengerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//@Override
	/*public String toString() {
		return "PassengerInfo [pId=" + pId + ", name=" + name + ", email=" + email + ", source=" + source
				+ ", Destination=" + Destination + ", travelDate=" + travelDate + ", pickupTime=" + pickupTime
				+ ", arrivalTime=" + arrivalTime + ", fare=" + fare + "]";
	}*/
	
	
	
	
	
	

}
