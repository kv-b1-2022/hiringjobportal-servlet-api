package com.demoapp;

import java.util.List;

import com.demoapp.dao.ViewDAO;
import com.demoapp.model.ViewCollege;

public class TestAddCollegeName {
	public static void main(String...args) throws Exception {
		String name ="GCE-poady";
		String keyName = "Gce-p";
		ViewCollege obj = new ViewCollege(); 
		obj.setCollege(name);
		obj.setKeyName(keyName);
		try {
		List<ViewCollege> list = ViewDAO.getCollegeNames();
		System.out.println(list);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
