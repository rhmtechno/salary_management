package com.rhmtech.management.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.EmpTransactionRepo;
import com.rhmtech.management.api.model.Company_bank_acc;
import com.rhmtech.management.api.model.EmployeeTransaction;
import com.rhmtech.management.api.model.Employee_bank_acc;
import com.rhmtech.management.api.model.Salary;
import com.rhmtech.management.api.model.SalaryFinal;

@Service
public class TransferService {
	@Autowired
	private SalaryService sservice;
	@Autowired
	private SalaryFinalService fservice;
	@Autowired
	private CompanyService cservice;
	@Autowired
	private EmployeeBankService embservice;
	@Autowired
	private EmpTransactionRepo transactionRepo;

	public boolean validate(String cacc) {
		Salary totalSalary = sservice.totalSalary();
		float totalSalary2 = totalSalary.getTotalSalary();

		Company_bank_acc findByAccnumber = cservice.findByAccnumber(cacc);
		float curr_bal = findByAccnumber.getCurr_bal();

		if (curr_bal >= totalSalary2) {
			return true;
		} else {
			return false;
		}

	}

	public boolean InitiateTransfer(String accno) {

		List<Salary> Allsalary = sservice.getSalary();

		Allsalary.stream().forEach(salary -> {
			long getsId = salary.getsId();
			float totalSalary = salary.getTotalSalary();
			float curr_bal = salary.getCurr_bal();
			Employee_bank_acc findEmplyee = embservice.findEmplyee(getsId);

			float newBal = curr_bal + totalSalary;
			findEmplyee.setCurr_bal(newBal);
			if (findEmplyee != null) {
				// update new Balance
				embservice.savebAccount(findEmplyee);
				//add transaction employee
				EmployeeTransaction et=new EmployeeTransaction();
				et.setAccId(getsId);
				et.setEmp_id(salary.getEmp_id());
				et.setAmount(totalSalary);
				et.setAccfrom(accno);
				transactionRepo.save(et);
				//
				SalaryFinal sl=new SalaryFinal();
				sl.setEmp_id(salary.getEmp_id());
				sl.setEmp_name(salary.getEmp_name());
				sl.setSalary_grade(salary.getSalary_grade());
				sl.setEmp_address(salary.getEmp_address());
				sl.setEmp_mobile(salary.getEmp_mobile());
				sl.setAccnumber(salary.getAccnumber());
				sl.setAcc_name(salary.getAcc_name());
				sl.setAcc_type(salary.getAcc_type());
				sl.setCurr_bal(salary.getCurr_bal());
				sl.setBank_name(salary.getBank_name());
				sl.setBank_branch(salary.getBank_branch());
				sl.setGradename(salary.getGradename());
				sl.setBasicAmount(salary.getBasicAmount());
				sl.setHouseRent(salary.getHouseRent());
				sl.setMedicalAllowance(salary.getMedicalAllowance());
				sl.setTotalSalary(salary.getTotalSalary());	
				fservice.saveCompleteData(sl);
				
				Company_bank_acc findByAccnumber = cservice.findByAccnumber(accno);
				float curr_balcompany = findByAccnumber.getCurr_bal();
				float newComBal = curr_balcompany - totalSalary;
				findByAccnumber.setCurr_bal(newComBal);
				if (findByAccnumber != null) {
					// update new balance
					cservice.addNew(findByAccnumber);
				}

			}

		});
		
		return true;
	}

}
