package com.rhmtech.management.api.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rhmtech.management.api.model.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Long> {

	@Query(value = "select 1 as s_id, emp.emp_id,emp.emp_address,emp.salary_grade,emp.emp_mobile,emp.emp_name,ebt.acc_name,ebt.acc_type,\r\n"
			+ "ebt.accnumber,ebt.bank_branch,ebt.bank_name,ebt.curr_bal,gt.basic_amount,gt.gradename,gt.house_rent,gt.medical_allowance,\r\n"
			+ "gt.basic_amount+(gt.basic_amount*(gt.house_rent)/100)+(gt.basic_amount*(gt.medical_allowance)/100) as total_salary\r\n"
			+ "from employee_tbl emp\r\n"
			+ "INNER JOIN employee_bank_tbl ebt\r\n"
			+ "on emp.fk_acc_id=ebt.accid\r\n"
			+ "INNER JOIN grade_tbl gt\r\n"
			+ "on emp.salary_grade=gt.gradeid",nativeQuery = true)
	List<Salary> getAllSalary();
	
	
	@Query(value = "select  1 as s_id, emp.emp_id,emp.emp_address,emp.salary_grade,emp.emp_mobile,emp.emp_name,ebt.acc_name,ebt.acc_type,\r\n"
			+ "ebt.accnumber,ebt.bank_branch,ebt.bank_name,ebt.curr_bal,gt.basic_amount,gt.gradename,gt.house_rent,gt.medical_allowance,\r\n"
			+ "gt.basic_amount+(gt.basic_amount*(gt.house_rent)/100)+(gt.basic_amount*(gt.medical_allowance)/100) as total_salary\r\n"
			+ "from employee_tbl emp\r\n"
			+ "INNER JOIN employee_bank_tbl ebt\r\n"
			+ "on emp.fk_acc_id=ebt.accid\r\n"
			+ "INNER JOIN grade_tbl gt\r\n"
			+ "on emp.salary_grade=gt.gradeid and emp_id=? ",nativeQuery = true)
	Salary getAllSalary(long id);

}
