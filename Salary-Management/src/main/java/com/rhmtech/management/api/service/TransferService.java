package com.rhmtech.management.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.EmpTransactionRepo;
import com.rhmtech.management.api.model.Company_bank_acc;
import com.rhmtech.management.api.model.EmployeeTransaction;
import com.rhmtech.management.api.model.Employee_bank_acc;
import com.rhmtech.management.api.model.Salary;

@Service
public class TransferService {
	@Autowired
	private SalaryService sservice;
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
				//add transaction
				EmployeeTransaction et=new EmployeeTransaction();
				et.setAccId(getsId);
				et.setEmp_id(salary.getEmp_id());
				et.setAmount(totalSalary);
				et.setAccfrom(accno);
				transactionRepo.save(et);
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
