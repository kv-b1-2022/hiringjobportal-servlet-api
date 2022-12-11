package com.demoapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.demoapp.dao.ViewDAO;
import com.demoapp.model.ViewCollege;

/**
 * list of college name						
 */
class ViewCollegeName {

	@Test
	void test() {
		List<ViewCollege> list = ViewDAO.getCollegeNames();
		assertEquals("not valid",0,list.size());
	}
	
	@Test
	void test1() {
		List<ViewCollege> list = ViewDAO.getCollegeNames();
		assertNotEquals("valid",0,list.size());
	}

}
