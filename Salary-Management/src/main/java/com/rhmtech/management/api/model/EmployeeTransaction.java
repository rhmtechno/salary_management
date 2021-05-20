package com.rhmtech.management.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Emp_Transaction_tbl")
public class EmployeeTransaction {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "empTransaction_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private long p_key_id;
	private long accId;
	private long emp_id;
	@UpdateTimestamp
	private Date updateTime;
	private float amount;
	private String accfrom;
	public long getP_key_id() {
		return p_key_id;
	}
	public void setP_key_id(long p_key_id) {
		this.p_key_id = p_key_id;
	}
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getAccfrom() {
		return accfrom;
	}
	public void setAccfrom(String accfrom) {
		this.accfrom = accfrom;
	}
	
	
	
}
