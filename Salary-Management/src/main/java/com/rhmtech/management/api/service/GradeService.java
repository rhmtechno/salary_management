package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.GradeRepo;
import com.rhmtech.management.api.model.SalaryGrade;

@Service
public class GradeService {
	@Autowired
	private GradeRepo gradeRepo;

	public List<SalaryGrade> fetchAllGrade() {
		return gradeRepo.findAll();
	}

	public SalaryGrade findEmplyee(long id) {
		Optional<SalaryGrade> findById = gradeRepo.findById(id);
		if (findById.isPresent()) {
			SalaryGrade acc = findById.get();
			return acc;
		} else {
			System.out.println("Employee Not availble in Db");
		}
		return null;
	}

	public SalaryGrade updateGrade(long id, SalaryGrade acc) {
		SalaryGrade getaccInfo = findEmplyee(id);
		if (getaccInfo != null) {
			return gradeRepo.save(acc);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String deleteAcc(long id) {
		SalaryGrade getaccInfo = findEmplyee(id);
		if (getaccInfo != null) {
			gradeRepo.delete(getaccInfo);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public SalaryGrade findBygrade(long id) {

		return gradeRepo.findByGradeid(id);
	}

	public SalaryGrade addGrade(SalaryGrade grade) {
		
		return gradeRepo.save(grade);
	}

}
