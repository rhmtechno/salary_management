package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.management.api.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
