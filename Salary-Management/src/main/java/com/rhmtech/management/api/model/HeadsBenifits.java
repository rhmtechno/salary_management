package com.rhmtech.management.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "benifits_tbl")
public class HeadsBenifits {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "benifits_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private long benifitId;
	private String benifitName;
	private float benifiteRate;
	private int isActive;
	@CreationTimestamp
	private Date createDate;
	public float getBenifiteRate() {
		return benifiteRate;
	}

	public void setBenifiteRate(float benifiteRate) {
		this.benifiteRate = benifiteRate;
	}

	public long getBenifitId() {
		return benifitId;
	}

	public void setBenifitId(long benifitId) {
		this.benifitId = benifitId;
	}

	public String getBenifitName() {
		return benifitName;
	}

	public void setBenifitName(String benifitName) {
		this.benifitName = benifitName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
