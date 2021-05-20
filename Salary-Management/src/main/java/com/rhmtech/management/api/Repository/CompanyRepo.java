package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.management.api.model.Company_bank_acc;
@Repository
public interface CompanyRepo extends JpaRepository<Company_bank_acc, Long> {

	Company_bank_acc findByAccnumber(String accnumber);

}
