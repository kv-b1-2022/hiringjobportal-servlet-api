package com.demoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ViewCourses {
	
	private int id = 0;

	private String keys = null;

	private String cource = null;

}
