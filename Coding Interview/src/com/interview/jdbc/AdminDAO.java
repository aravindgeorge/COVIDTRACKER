package com.interview.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.interview.model.Admin;
import com.interview.model.User;

public class AdminDAO {
	public static void createAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "insert into covid_tracker_admin values(covid_tracker_admin_seq.nextval,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql,new String[] {"Id"});
		st.setString(1,admin.getName());
		st.setString(2,admin.getPhoneNumber());
		st.setString(3,admin.getPinCode());
		
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
		
		while(rs.next()) {
			admin.setId(rs.getInt(1));
		}
	}

	public static Admin getAdmin(int adminId) throws SQLException, ClassNotFoundException {
		Connection con = ConnectionFactory.getConnetcion();
		String sql = "select * from covid_tracker_admin where id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,adminId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		//System.out.println("User not foundfor userId - "+userId);
		return null;
	}
}
