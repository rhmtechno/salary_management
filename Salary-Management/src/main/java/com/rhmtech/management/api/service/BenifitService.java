package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rhmtech.management.api.Repository.BenifitsRepo;
import com.rhmtech.management.api.model.HeadsBenifits;
@Service
public class BenifitService {
	@Autowired
	private BenifitsRepo benifitsRepo;

	public List<HeadsBenifits> fetchAll() {
		return benifitsRepo.findAll();
	}

	public HeadsBenifits findOne(long id) {
		Optional<HeadsBenifits> findById = benifitsRepo.findById(id);
		if (findById.isPresent()) {
			HeadsBenifits acc = findById.get();
			return acc;
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public HeadsBenifits doUpdate(long id, HeadsBenifits payload) {
		HeadsBenifits getaccInfo = findOne(id);
		if (getaccInfo != null) {
			return benifitsRepo.save(payload);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String doDelete(long id) {
		HeadsBenifits getaccInfo = findOne(id);
		if (getaccInfo != null) {
			benifitsRepo.delete(getaccInfo);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public HeadsBenifits addNew(HeadsBenifits payload) {
		return benifitsRepo.save(payload);
	}

	
}
