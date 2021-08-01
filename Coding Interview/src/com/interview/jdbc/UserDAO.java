package com.interview.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.interview.model.User;

public class UserDAO {

	public static void createUser(User user) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "insert into covid_tracker_user values(covid_tracker_user_seq.nextval,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql,new String[] {"Id"});
		st.setString(1,user.getName());
		st.setString(2,user.getPhoneNumber());
		st.setString(3,user.getPinCode());
		st.setString(4,user.getCovidStatus());
		
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
		
		while(rs.next()) {
			user.setId(rs.getInt(1));
		}
	}

	public static User getUser(int userId) throws SQLException, ClassNotFoundException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "select * from covid_tracker_user where id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,userId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		//System.out.println("User not foundfor userId - "+userId);
		return null;
	}

	public static void updateCovidStatus(User user, String covidStatus) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "update covid_tracker_user set covidstatus = ? where id = ?";
		PreparedStatement st = con.prepareStatement(sql,new String[] {"Id"});
		st.setString(1,covidStatus);
		st.setInt(2,user.getId());
		
		int res = st.executeUpdate();
		if(res>0) {
			user = getUser(user.getId());
			System.out.println("Covid Status updated for "+user);
		}else {
			System.out.println("failed to update covid status");
		}
	}

	public static int getNumberOfPositiveCasesInZone(String pinCode) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "select count(1) from covid_tracker_user where pincode = ? and covidstatus = 'P'";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,pinCode);
		ResultSet rs = st.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			count = rs.getInt(1);
		}
		//System.out.println("User not foundfor userId - "+userId);
		return count;
	}
}
