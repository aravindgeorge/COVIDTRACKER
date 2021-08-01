package com.interview.model;

import java.sql.SQLException;

import com.interview.CovidTackerSystem;
import com.interview.jdbc.UserDAO;

public class Admin {
	int id;
	String name;
	String phoneNumber;
	String pinCode;
	public Admin(String name, String phoneNumber, String pinCode) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pinCode = pinCode;
	}
	public Admin(int id, String name, String phoneNumber, String pinCode) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", pinCode=" + pinCode + "]";
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
	public void enterCovidResult(int userId, String covidResult) throws ClassNotFoundException, SQLException {
		User user = UserDAO.getUser(userId);
		if(user==null) {
			System.out.println("enterCovidResult : User not found for userId - "+userId);
			return;
		}
		if(CovidTackerSystem.POSITIVE.equals(covidResult)){
			if(CovidTackerSystem.POSITIVE_KEY.equals(user.getCovidStatus())) {
				System.out.println(user +" is already covid positive");
				return;
			}
			UserDAO.updateCovidStatus(user,CovidTackerSystem.POSITIVE_KEY);
		}else if(CovidTackerSystem.NEGATIVE.equals(covidResult)){
			if(CovidTackerSystem.NEGATIVE_KEY.equals(user.getCovidStatus())) {
				System.out.println(user +" is already covid negative");
				return;
			}
			UserDAO.updateCovidStatus(user,CovidTackerSystem.NEGATIVE_KEY);
		}
	}
	
}
