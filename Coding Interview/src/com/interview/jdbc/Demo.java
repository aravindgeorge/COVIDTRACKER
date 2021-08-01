package com.interview.jdbc;

import java.sql.SQLException;

import com.interview.CovidTackerSystem;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//CovidTackerSystem.createUser("Arun", "9999999888", "666777");
		//CovidTackerSystem.selfAssessment(1,new String[] {"fever","cold","cough"},true,true);
		//CovidTackerSystem.selfAssessment(2,new String[] {},false,false);
		//CovidTackerSystem.createAdmin("Priya", "9999999866", "666777");
		//CovidTackerSystem.getAdmin(1);
		CovidTackerSystem.enterCovidResult(1,1,"negative");
		CovidTackerSystem.getZoneInfo("666777");
	}
}
