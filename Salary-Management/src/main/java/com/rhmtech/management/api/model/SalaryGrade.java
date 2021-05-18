package com.rhmtech.management.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade_tbl")
public class SalaryGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_pk_key;
	private String gradename;
	private long gradeid;
	private float gradeamount;
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
	public float getGradeamount() {
		return gradeamount;
	}
	public void setGradeamount(float gradeamount) {
		this.gradeamount = gradeamount;
	}
	@Override
	public String toString() {
		return "SalaryGrade [id_pk_key=" + id_pk_key + ", gradename=" + gradename + ", gradeid=" + gradeid
				+ ", gradeamount=" + gradeamount + "]";
	}
	
	

}
