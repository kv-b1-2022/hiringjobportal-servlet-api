package com.demoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demoapp.dataBaseConnection.Databasecon;
import com.demoapp.model.ViewCollege;
import com.demoapp.model.ViewCourses;
import com.demoapp.utility.HibernateUtil;



public class ViewDAO {

	@SuppressWarnings("finally")
	public static  ArrayList<ViewCourses> getSpecifications() throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		ArrayList<ViewCourses> jobFiles = new ArrayList<ViewCourses>();
		try {
			// Prepare SQL.
			query = ("SELECT * FROM specification");
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			ViewCourses view = null;
			// Get data from database.
			while (rs.next()) {
				// object greation for userDetails class
				view = new ViewCourses();
				view.setId(rs.getInt("id"));
				view.setKeys(rs.getString("key_values"));
				view.setCource(rs.getString("course"));
				jobFiles.add(view);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return jobFiles;
		}

	}

	@SuppressWarnings("finally")
//	public static ArrayList<ViewCollege> getCollegeNames() throws Exception {
//		Connection con = Databasecon.getConnection();
//		String query = null;
//		ArrayList<ViewCollege> jobFiles = new ArrayList<ViewCollege>();
//		try {
//			// Prepare SQL.
//			query = ("SELECT key_name,college FROM college_names");
//			PreparedStatement statement = con.prepareStatement(query);
//			ResultSet rs = statement.executeQuery();
//			ViewCollege view = null;
//			while (rs.next()) {
//				// object greation for userDetails class
//				view = new ViewCollege();
//				view.setKeyName(rs.getString("key_name"));
//				view.setCollege(rs.getString("college"));
//				jobFiles.add(view);
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		} finally {
//			con.close();
//			return jobFiles;
//		}
//	}
	
	
	public static List<ViewCollege> getCollegeNames() {
		Session sc = HibernateUtil.getSession();
		Query<ViewCollege> user = sc.createQuery("select u from com.demoapp.model.ViewCollege u", ViewCollege.class);
		return user.getResultList();
	}
}
