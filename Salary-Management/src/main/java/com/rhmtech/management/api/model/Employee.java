package com.rhmtech.management.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "employee_Tbl")
public class Employee implements Serializable {
	private static final long serialVersionUID = 3084087052637800584L;
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "emp_sequence"),
			@Parameter(name = "initial_value", value = "1000"), @Parameter(name = "increment_size", value = "1") })
	@Column(name = "emp_id")
	private long id_key;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "salary_grade")
	private String grade;
	@Column(name = "emp_address")
	private String address;
	@Column(name = "emp_mobile")
	private String mobile;
	@OneToOne(targetEntity = Employee_bank_acc.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_emp_bank", referencedColumnName = "bid", nullable = false, updatable = false)
	private Employee_bank_acc emp_bank;

	public long getId_key() {
		return id_key;
	}

	public void setId_key(long id_key) {
		this.id_key = id_key;
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

	public Employee_bank_acc getEmp_bank() {
		return emp_bank;
	}

	public void setEmp_bank(Employee_bank_acc emp_bank) {
		this.emp_bank = emp_bank;
	}

}
