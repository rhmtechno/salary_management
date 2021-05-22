package com.rhmtech.management.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "Salary_Final_tbl")
public class SalaryFinal {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "salary_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	@Column(nullable = true)
	private long sId;
	private long emp_id;
	private String emp_name;
	private long salary_grade;
	private String emp_address;
	private String emp_mobile;
	private String accnumber;
	private String acc_name;
	private String acc_type;
	private float curr_bal;
	private String bank_name;
	private String bank_branch;
	private String gradename;
	private float basicAmount;
	private float houseRent;
	private float medicalAllowance;
	private float totalSalary;
	@CreationTimestamp
	private Date CreateTime;
	
	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public float getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	public float getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(float houseRent) {
		this.houseRent = houseRent;
	}

	public float getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(float medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public long getSalary_grade() {
		return salary_grade;
	}

	public void setSalary_grade(long salary_grade) {
		this.salary_grade = salary_grade;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	public String getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public float getCurr_bal() {
		return curr_bal;
	}

	public void setCurr_bal(float curr_bal) {
		this.curr_bal = curr_bal;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_branch() {
		return bank_branch;
	}

	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public float getBasicAmount() {
		return basicAmount;
	}

	public void setBasicAmount(float basicAmount) {
		this.basicAmount = basicAmount;
	}


}
