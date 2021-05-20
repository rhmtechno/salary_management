package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rhmtech.management.api.Repository.CompanyRepo;
import com.rhmtech.management.api.model.Company_bank_acc;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepo companyRepo;

	public List<Company_bank_acc> fetchAll() {
		return companyRepo.findAll();
	}

	public Company_bank_acc findOne(long id) {
		Optional<Company_bank_acc> findById = companyRepo.findById(id);
		if (findById.isPresent()) {
			Company_bank_acc acc = findById.get();
			return acc;
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public Company_bank_acc doUpdate(long id, Company_bank_acc payload) {
		Company_bank_acc getaccInfo = findOne(id);
		if (getaccInfo != null) {
			payload.setAccid(getaccInfo.getAccid());
			return companyRepo.save(payload);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String doDelete(long id) {
		Company_bank_acc getaccInfo = findOne(id);
		if (getaccInfo != null) {
			companyRepo.delete(getaccInfo);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public Company_bank_acc addNew(Company_bank_acc payload) {
		return companyRepo.save(payload);
	}

	public Company_bank_acc findByAccnumber(String accnumber) {
		return companyRepo.findByAccnumber(accnumber);

	}

	public Company_bank_acc AddBalance(String accnumber, float balance) {
		Company_bank_acc findByAccnumber = companyRepo.findByAccnumber(accnumber);
		if (findByAccnumber != null) {
			float curr_bal = findByAccnumber.getCurr_bal();
			float newbal = curr_bal + balance;
			findByAccnumber.setCurr_bal(newbal);
			companyRepo.save(findByAccnumber);
		}

		return findByAccnumber;

	}

}
