package com.interview.model;

public class User {
	int id;
	String name;
	String phoneNumber;
	String pinCode;
	String covidStatus;
	public User(String name, String phoneNumber, String pinCode, String covidStatus) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pinCode = pinCode;
		this.covidStatus = covidStatus;
	}
	public User(int id, String name, String phoneNumber, String pinCode, String covidStatus) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pinCode = pinCode;
		this.covidStatus = covidStatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", pinCode=" + pinCode
				+ ", covidStatus=" + covidStatus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getPinCode() {
		return pinCode;
	}
	public String getCovidStatus() {
		return covidStatus;
	}
	
	
}
