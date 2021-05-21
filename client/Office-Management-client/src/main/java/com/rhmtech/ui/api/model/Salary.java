package com.rhmtech.ui.api.model;

public class Salary {
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

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salary(float totalSalary) {
		super();
		this.totalSalary = totalSalary;
	}
	
	/*
	 * public Salary(long emp_id, String emp_name, long salary_grade, String
	 * emp_address, String emp_mobile, String accnumber, String acc_name, String
	 * acc_type, float curr_bal, String bank_name, String bank_branch, String
	 * gradename, float basicAmount, float houseRent, float medicalAllowance, float
	 * totalSalary) { super(); this.emp_id = emp_id; this.emp_name = emp_name;
	 * this.salary_grade = salary_grade; this.emp_address = emp_address;
	 * this.emp_mobile = emp_mobile; this.accnumber = accnumber; this.acc_name =
	 * acc_name; this.acc_type = acc_type; this.curr_bal = curr_bal; this.bank_name
	 * = bank_name; this.bank_branch = bank_branch; this.gradename = gradename;
	 * this.basicAmount = basicAmount; this.houseRent = houseRent;
	 * this.medicalAllowance = medicalAllowance; this.totalSalary = totalSalary; }
	 */
	

}
