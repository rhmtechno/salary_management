package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhmtech.management.api.model.EmployeeTransaction;

public interface EmpTransactionRepo extends JpaRepository<EmployeeTransaction, Long> {

}
