package com.rhmtech.management.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "grade_tbl")
public class SalaryGrade {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "grade_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private long id_pk_key;
	private String gradename;
	private long gradeid;
	private float basicAmount;
	public long getId_pk_key() {
		return id_pk_key;
	}
	public void setId_pk_key(long id_pk_key) {
		this.id_pk_key = id_pk_key;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	public long getGradeid() {
		return gradeid;
	}
	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}
	public float getBasicAmount() {
		return basicAmount;
	}
	public void setBasicAmount(float basicAmount) {
		this.basicAmount = basicAmount;
	}

	
	

}
