package com.demoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demoapp.dataBaseConnection.Databasecon;
import com.demoapp.model.JobProfile;
import com.demoapp.validation.CTCValidation;

public class JobsDAO {
	public static int exceqution(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		System.out.println("number of rows=" + query);
		int rows = statement.executeUpdate(query);
		connection.close();
		return rows;

	}

	public static ResultSet excequtionSelect(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		System.out.println("number of rows=" + rs);
		return rs;

	}

	@SuppressWarnings("finally")
	public static int jobinsert(JobProfile obj) throws Exception {

		Connection con = Databasecon.getConnection();
		int rows = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into hiring_companys (job_id,branch,companyName,roll ,vacancy,location_details,finish_date,skills,salary,mail_id) values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, obj.getjobId());
			stmt.setString(2, obj.getBranch());
			stmt.setString(3, obj.getCompanyName());
			stmt.setString(4, obj.getroll());
			stmt.setInt(5, obj.getvacancy());
			stmt.setString(6, obj.getlocation_details());
			stmt.setString(7, obj.getfinish_date());
			stmt.setString(8, obj.getskills());
			stmt.setInt(9, obj.getsalery());
			stmt.setString(10, obj.getMailId());
			rows = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return rows;
		}
	}

	public static int jobDelete(int jobId) throws Exception {

		JobProfile obj = new JobProfile();
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			query = "delete  from hiring_companys where job_id	= ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, obj.getjobId());
			t = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;

	}

	@SuppressWarnings("finally")
	public static int jobUpdate() throws Exception {

		JobProfile obj = new JobProfile();
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			query = "update hiring_companys set vacancy = ? where job_id = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, obj.getvacancy());
			stmt.setInt(2, obj.getjobId());
			t = stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return t;
		}

	}

	@SuppressWarnings("finally")
	public static ArrayList<JobProfile> jobSearchigSkills(JobProfile jobProfile) throws Exception {

		Connection con = Databasecon.getConnection();
		String query = null;
		ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();
		try {
			// Prepare SQL.
			query = "select * from hiring_companys where skills = ? and vacancy > 0 ";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, jobProfile.getskills());

			// Execute SQL query.
			ResultSet rs = stmt.executeQuery();

			
			while (rs.next()) {
				JobProfile jobFile = new JobProfile();
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salary"));
				jobFiles.add(jobFile);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return jobFiles;
			
		}
	}

	@SuppressWarnings("finally")
	public List<JobProfile> getAllDetails() throws Exception {

		String query1 = null;
		Connection con = Databasecon.getConnection();
		List<JobProfile> jobFiles = new ArrayList<JobProfile>();
		try {
			// Prepare SQL.
			query1 = "select * from hiring_companys";

			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);

			JobProfile jobFile = null;

			// Get data from database.


			while (rs.next()) {
				jobFile = new JobProfile();

				String branch = rs.getString("branch");
				String company = rs.getString("companyName");
				String roll = rs.getString("roll");
				int vacancy = rs.getInt("vacancy");
				String place_details = rs.getString("location_details");
				String skills = rs.getString("skills");
				int salary = rs.getInt("salary");
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(branch);
				jobFile.setCompany(company);
				jobFile.setRoll(roll);
				jobFile.setVacancy(vacancy);
				jobFile.setPlace_Details(place_details);
				jobFile.setSkills(skills);
				jobFile.setSalery(salary);
				jobFiles.add(jobFile);

			}
			jobFile.printAllDetails(jobFile);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return jobFiles;
		}
	}

	public static int jobUpdateVacancy(int id) {

		String query1 = null;
		int t = 0;
		String result = null;
		StringBuilder querystr1 = new StringBuilder();

		try {
			querystr1.append("update hiring_companys set vacancy = (vacancy-1) where companyName = ('").append(id)
					.append("')");

			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	public static int jobsCount() throws Exception {
		JobProfile obj = new JobProfile();
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			// Prepare SQL.
			query = "select * from hiring_companys where skills = ? and vacancy > 0 ";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getskills());

			// Execute SQL.
			ResultSet rs = stmt.executeQuery();
			JobProfile jobFile = null;

			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();

			while (rs.next()) {
				t++;
				jobFile = new JobProfile();

				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salary"));
				jobFiles.add(jobFile);
//				jobFile.print1(jobFiles);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
		}
		return t;
	}

	@SuppressWarnings("finally")
	public static int jobUpdateSkills(JobProfile details) throws Exception {

		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			query = "update hiring_companys set Skills = ? where job_id = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, details.getskills());
			stmt.setInt(2, details.getjobId());
			t = stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return t;
		}

	}

	@SuppressWarnings("finally")
	public static int jobUpdateSalery(JobProfile details) throws Exception {

		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			query = "update hiring_companys set salary = ? where job_id = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, details.getSalary());
			stmt.setInt(2, details.getjobId());
			t = stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return t;
		}

	}

	@SuppressWarnings("finally")
	public static int DisplayJobs(String mailId) throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		int a = 0;
		try {
			// Prepare SQL.
			query = "select * from hiring_companys where mail_id = ?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, mailId);

			// Execute SQL.
			ResultSet rs = stmt.executeQuery();

			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();
			while (rs.next()) {
				a++;
				JobProfile jobFile = new JobProfile();
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salary"));
				jobFiles.add(jobFile);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return a;
		}

	}

	@SuppressWarnings("finally")
	public List<JobProfile> getAllDetailsSalary() throws Exception {
		String query1 = null;
		Connection con = Databasecon.getConnection();
		List<JobProfile> jobFiles = new ArrayList<JobProfile>();
		try {
			// Prepare SQL.
			query1 = "select * from hiring_companys";

			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);

			JobProfile jobFile = null;

			// Get data from database.


			while (rs.next()) {
				jobFile = new JobProfile();

				String branch = rs.getString("branch");
				String company = rs.getString("companyName");
				String roll = rs.getString("roll");
				int vacancy = rs.getInt("vacancy");
				String place_details = rs.getString("location_details");
				String skills = rs.getString("skills");
				int salary = rs.getInt("salary");
				String cTC = CTCValidation.validation(salary);
				jobFile.setJobId(rs.getInt("job_id"));
				
				jobFile.setBranch(branch);
				jobFile.setCompany(company);
				jobFile.setRoll(roll);
				jobFile.setVacancy(vacancy);
				jobFile.setPlace_Details(place_details);
				jobFile.setSkills(skills);
				jobFile.setSalery(salary);
				jobFiles.add(jobFile);

			}
			jobFile.printAllDetails(jobFile);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return jobFiles;
		}
	}
}
