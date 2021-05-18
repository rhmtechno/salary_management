package com.rhmtech.management.api.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Employee_bank_tbl")
public class Employee_bank_acc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5539989045744321074L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accid;
	private long accno;
	private String acc_name;
	private String acc_type;
	private float curr_bal;
	private String bank_name;
	private String bank_branch;
	@CreationTimestamp
	@Column(updatable = false)
	private Date Creation_date;
	
	
	
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public long getAccid() {
		return accid;
	}
	public void setAccid(long accid) {
		this.accid = accid;
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
	public Date getCreation_date() {
		return Creation_date;
	}
	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}
	
	

}
