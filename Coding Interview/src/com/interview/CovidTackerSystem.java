package com.interview;

import java.sql.SQLException;

import com.interview.jdbc.AdminDAO;
import com.interview.jdbc.UserDAO;
import com.interview.model.Admin;
import com.interview.model.User;

public class CovidTackerSystem {
	public static String POSITIVE = "positive";
	public  static String NEGATIVE = "negative";
	public static String POSITIVE_KEY = "P";
	public  static String NEGATIVE_KEY = "N";
	
	public static User createUser(String name,String phoneNumber,String pinCode) throws ClassNotFoundException, SQLException {
		User user = new User(name, phoneNumber, pinCode, "N");
		UserDAO.createUser(user);
		System.out.println("User created with userId - "+user.getId());
		return user;
	}
	
	

	public static void selfAssessment(int userId, String[] symptoms, boolean travelHistory, boolean contactWithCovidPatient) throws ClassNotFoundException, SQLException {
		User user = UserDAO.getUser(userId);
		if(user!=null) {
			
			int percentage = 5;
			if(symptoms.length>2) {
				percentage = 95;
			}else if(symptoms.length==2) {
				percentage = 75;
			}else if(symptoms.length==1 || travelHistory || contactWithCovidPatient) {
				percentage = 50;
			}
			System.out.println("riskPercentage for "+user+" is "+percentage);
		}else {
			System.out.println("User not found for userId - "+userId);
		}
	}



	public static Admin createAdmin(String name,String phoneNumber,String pinCode) throws ClassNotFoundException, SQLException {
		Admin admin = new Admin(name, phoneNumber, pinCode);
		AdminDAO.createAdmin(admin);
		System.out.println("Admin created with adminId - "+admin.getId());
		return admin;
	}
	
	public static Admin getAdmin(int adminId) throws ClassNotFoundException, SQLException {
		Admin admin = AdminDAO.getAdmin(adminId);
		if(admin!=null) {
			System.out.println("getAdmin : "+ admin);
		}else {
			System.out.println("Admin not found for adminId - "+adminId);
		}
		return admin;
	}



	public static void enterCovidResult(int userId, int adminId, String covidResult) throws ClassNotFoundException, SQLException {
		Admin admin = AdminDAO.getAdmin(adminId);
		if(admin==null) {
			System.out.println("enterCovidResult : Admin not found for adminId - "+adminId);
			return;
		}
		admin.enterCovidResult(userId,covidResult);
	}



	public static void getZoneInfo(String pinCode) throws ClassNotFoundException, SQLException {
		int numberOfPositiveCases = UserDAO.getNumberOfPositiveCasesInZone(pinCode);
		String zoneType = "GREEN";
		if(numberOfPositiveCases>5) {
			zoneType = "RED";
		}else if(numberOfPositiveCases>0) {
			zoneType = "ORANGE";
		}
		System.out.println("getZoneInfo for pinCode - "+pinCode);
		System.out.println("numCases - "+numberOfPositiveCases+" zoneType - "+zoneType);
	}
	
}
