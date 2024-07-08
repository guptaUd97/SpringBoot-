package com.demo.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

//import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "PAYMENT_INFO")
	@JsonInclude(value = Include.NON_NULL)
	public class PaymentInfo<UUId> {

		//@Id
		//@GeneratedValue(generator = "uuid2")
		//@GenericGenerator(name = "uuid2", strategy = "uuid")
		//@JsonInclude(value = Include.NON_NULL)
		
		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
		
		
		private String paymentId;
		private String accountNo;
		private double amount;
		private String cardType;
		private Long passengerId;

		

		

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		public Long getPassengerId() {
			return passengerId;
		}

		public void setPassengerId(Long passengerId) {
			this.passengerId = passengerId;
		}

		/*public PaymentInfo(String paymentId, String accountNo, double amount, String cardType, Long passengerId) {
			super();
			this.paymentId = paymentId;
			this.accountNo = accountNo;
			this.amount = amount;
			this.cardType = cardType;
			this.passengerId = passengerId;
		}

		@Override
		public String toString() {
			return "PaymentInfo [paymentId=" + paymentId + ", accountNo=" + accountNo + ", amount=" + amount + ", cardType="
					+ cardType + ", passengerId=" + passengerId + "]";
		}

		public PaymentInfo() {
			super();

		}*/
		

	}



