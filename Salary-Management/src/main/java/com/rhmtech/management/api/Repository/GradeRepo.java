package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.management.api.model.SalaryGrade;
@Repository
public interface GradeRepo extends JpaRepository<SalaryGrade, Long> {

	SalaryGrade findByGradeid(long id);

}
