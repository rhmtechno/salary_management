package com.rhmtech.ui.api.model;

public class SalaryGrade {
	private long id_pk_key;
	private String gradename;
	private long gradeid;
	private float basicAmount;
	private float houseRent;
	private float medicalAllowance;

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
