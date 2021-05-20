package com.rhmtech.ui.api.model;

import java.io.Serializable;


public class Employee implements Serializable {
	private static final long serialVersionUID = 3084087052637800584L;


	private long emp_id;

	private String name;

	private long grade;

	private String address;

	private String mobile;

	private Employee_bank_acc emp_bank;

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Employee_bank_acc getEmp_bank() {
		return emp_bank;
	}

	public void setEmp_bank(Employee_bank_acc emp_bank) {
		this.emp_bank = emp_bank;
	}

	

}
