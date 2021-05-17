package com.rhmtech.management.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "employee_Tbl")
public class Employee {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "emp_sequence"),
	@Parameter(name = "initial_value", value = "1000"), 
	@Parameter(name = "increment_size", value = "1") })
	@Column(name = "emp_id")
	private long id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "salary_grade")
	private String grade;
	@Column(name = "emp_address")
	private String address;
	@Column(name = "emp_mobile")
	private String mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
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

}
