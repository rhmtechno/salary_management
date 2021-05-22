package com.rhmtech.management.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.GradeRepo;
import com.rhmtech.management.api.model.HeadsBenifits;
import com.rhmtech.management.api.model.Rank;
import com.rhmtech.management.api.model.SalaryGrade;

@Service
public class GradeService {
	@Autowired
	private GradeRepo gradeRepo;
	@Autowired
	private BenifitService benifitService;
	@Autowired
	private RankService rservice;

	public List<SalaryGrade> fetchAllGrade() {
		
		return gradeRepo.findByOrderByGradeidAsc();
		//return gradeRepo.findAll();
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
			acc.setId_pk_key(getaccInfo.getId_pk_key());
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

	public List<SalaryGrade> addLowest(float lowestAmount, String[] gradeholder, float gratedif) {
		gradeRepo.deleteAll();
		List<SalaryGrade> slist = new ArrayList<>();

		Map<String, Float> datamap = processBenifits(getHeads());
		int counter = 0;
		for (int grade = gradeholder.length - 1; grade >= 0; grade--) {
			float amount = 0;
			amount += lowestAmount + (counter * gratedif);
			SalaryGrade sg = new SalaryGrade();
			String gname = gradeholder[grade];
			sg.setGradeid(grade + 1);
			sg.setGradename(gname);
			sg.setBasicAmount(amount);
			sg.setHouseRent(datamap.get("House rent"));
			sg.setMedicalAllowance(datamap.get("Medical allowance"));
			slist.add(sg);
			counter++;

		}
		gradeRepo.saveAll(slist);
		slist.clear();
		return gradeRepo.findAll();

	}

	private Map<String, Float> processBenifits(List<HeadsBenifits> heads) {
		Map<String, Float> datamap = new HashMap<>();
		heads.stream().parallel().forEach(bf -> {
			datamap.put(bf.getBenifitName(), bf.getBenifiteRate());
		});
		return datamap;

	}

	private List<HeadsBenifits> getHeads() {
		return benifitService.fetchAll();

	}

	public String[] getRank() {
		return processRank(rservice.fetchAll());
	}

	private String[] processRank(List<Rank> rank) {
		List<String> collect = rank.stream().parallel().map(r -> r.getRankName()).collect(Collectors.toList());
		String[] grade = new String[collect.size()];
		for (int i = 0; i < collect.size(); i++) {
			grade[i] = collect.get(i);
		}
		return grade;
	}

}
