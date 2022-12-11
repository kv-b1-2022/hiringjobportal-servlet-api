package com.demoapp.model;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="college_names")
public class ViewCollege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(name="key_name")
	private String keyName = null;
	
	@Column(name="college")
	private String college = null;

//	public String getKeyName() {
//		return keyName;
//	}
//
//	public void setKeyName(String keyName) {
//		this.keyName = keyName;
//	}
//
//	public String getCollege() {
//		return college;
//	}
//
//	public void setCollege(String college) {
//		this.college = college;
//	}
//
////	@Override
////	public String toString() {
////		return "ViewCollege [id=" + id + ", keyName=" + keyName + ", college=" + college + "]";
////	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public ViewCollege() {
//
//	}

}
