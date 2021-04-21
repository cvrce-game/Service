package com.service.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int addressrowId;
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private String postalCode;
	public int getAddressrowId() {
		return addressrowId;
	}
	public void setAddressrowId(int addressrowId) {
		this.addressrowId = addressrowId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Address [addressrowId=" + addressrowId + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", postalCode=" + postalCode + "]";
	}


}
