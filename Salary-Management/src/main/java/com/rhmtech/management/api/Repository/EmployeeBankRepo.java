package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.management.api.model.Employee_bank_acc;
@Repository
public interface EmployeeBankRepo extends JpaRepository<Employee_bank_acc, Long> {


	Employee_bank_acc findByAccnumber(String id);

}
