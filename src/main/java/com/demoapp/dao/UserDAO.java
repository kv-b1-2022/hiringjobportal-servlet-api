package com.demoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demoapp.dataBaseConnection.Databasecon;
import com.demoapp.model.UserDetails;

public class UserDAO {

	public static int exceqution(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		int rows = statement.executeUpdate(query);
		System.out.println("number of rows=" + rows);
		connection.close();
		return rows;

	}

	public static ResultSet excequtionSelect(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		connection.close();
		return rs;

	}

	public static int insert(UserDetails details, String gender, long phoneNumber) throws Exception {
		String query = null;
		int t = 0;
		Connection con = Databasecon.getConnection();
		try {
//			query = "insert into job_hiring (userMailId,userPass,userName,DOB,college_Name,cource,branch,gender,phone_Number) values"
//					+ "('"+details.getUserMailId()+"','"+details.getUserPass()+"','"+details.getUserName()+"','"+details.getDOB()+"','"+details.getCollegeName()+"','"+details.getCource()+"','"+details.getBranch()+"','"+gender+"','"+phoneNumber+"')";

			PreparedStatement stmt = con.prepareStatement("insert into job_hiring (userMailId,userPass,userName,DOB,college_Name,cource,branch,gender,phone_number) values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,details.getUserMailId());
			stmt.setString(2,details.getUserPass());
			stmt.setString(3,details.getUserName());
			stmt.setString(4,details.getDOB());
			stmt.setString(5,details.getCollegeName());
			stmt.setString(6,details.getCource());
			stmt.setString(7,details.getBranch());
			stmt.setString(8,gender);
			stmt.setLong(9,phoneNumber);

			t =  stmt.executeUpdate();
			//t =  exceqution( query);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return t;
	}

	@SuppressWarnings("finally")
	public static int checkValidation(String mailId, String password) throws Exception {
		String query = null;
		int result = 0;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId)
					.append("') or userPass = ('").append(password).append("')");
			query = querystr.toString();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result++;
			}
		} catch (Exception e) {
			connection.close();
			e.printStackTrace();
		} finally {

			return result;
		}
	}

	@SuppressWarnings("finally")
	public static int loginValidation(String mailId, String password) throws Exception {
		String query = null;
		int result = 0;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId)
					.append("') and userPass = ('").append(password).append("')");
			query = querystr.toString();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result++;
			}
		} catch (Exception e) {
			connection.close();
			e.printStackTrace();
		} finally {

			return result;
		}
	}

	@SuppressWarnings("finally")
	public static ArrayList<UserDetails> getAllDetails() throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		ArrayList<UserDetails> jobFiles = new ArrayList<UserDetails>();
		try {
			// Prepare SQL.
			query = ("SELECT userMailId,userName,DOB,college_Name,cource,branch FROM job_hiring");
			PreparedStatement statement = con.prepareStatement(query);

			ResultSet rs = statement.executeQuery();
			UserDetails userDetails = null;

			while (rs.next()) {

				// object greation for userDetails class
				userDetails = new UserDetails();

				userDetails.setUserMailId(rs.getString("userMailId"));
				userDetails.setUserName(rs.getString("userName"));
				userDetails.setDOB(rs.getString("DOB"));
				userDetails.setCollegeName(rs.getString("College_name"));
				userDetails.setCource(rs.getString("cource"));
				userDetails.setBranch(rs.getString("branch"));

				jobFiles.add(userDetails);

			}
//			userDetails.print(jobFiles);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return jobFiles;
		}

	}

	@SuppressWarnings("finally")
	public static String getSkills(String userMailId) throws Exception {

		Connection con = Databasecon.getConnection();
		String skills = null;
		String query = null;

		try {
			// Prepare SQL.
			query = "select branch from job_hiring where userMailId = ? ";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userMailId);
			// Execute SQL.
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				skills = rs.getString("branch");

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return skills;
		}
	}

	@SuppressWarnings("finally")
	public static List<UserDetails> getUserDetails(String mailId, String password) throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		ArrayList<UserDetails> jobFiles = new ArrayList<UserDetails>();
		try {
			// Prepare SQL.
			query = ("SELECT userMailId,userName,DOB,college_Name,cource,branch,phone_number FROM job_hiring where userMailId=? and userPass=?");
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, mailId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			UserDetails userDetails = null;

			while (rs.next()) {

				// object greation for userDetails class
				userDetails = new UserDetails();

				userDetails.setUserMailId(rs.getString("userMailId"));
				userDetails.setUserName(rs.getString("userName"));
				userDetails.setDOB(rs.getString("DOB"));
				userDetails.setCollegeName(rs.getString("College_name"));
				userDetails.setCource(rs.getString("cource"));
				userDetails.setBranch(rs.getString("branch"));
				userDetails.setPhoneNumber(rs.getLong("phone_number")); 
				System.out.println(rs.getLong("phone_number"));
				
				jobFiles.add(userDetails);

			}
//			userDetails.print(jobFiles);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return jobFiles;
		}

	}

	

}
