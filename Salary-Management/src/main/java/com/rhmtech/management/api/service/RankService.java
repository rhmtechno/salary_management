package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rhmtech.management.api.Repository.BenifitsRepo;
import com.rhmtech.management.api.Repository.RankRepo;
import com.rhmtech.management.api.model.HeadsBenifits;
import com.rhmtech.management.api.model.Rank;
@Service
public class RankService {
	@Autowired
	private RankRepo rankRepo;;

	public List<Rank> fetchAll() {
		return rankRepo.findAll();
	}

	public Rank findOne(long id) {
		Optional<Rank> findById = rankRepo.findById(id);
		if (findById.isPresent()) {
			Rank acc = findById.get();
			return acc;
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public Rank doUpdate(long id, Rank payload) {
		Rank getaccInfo = findOne(id);
		if (getaccInfo != null) {
			payload.setRankId(getaccInfo.getRankId());
			return rankRepo.save(payload);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String doDelete(long id) {
		Rank getaccInfo = findOne(id);
		if (getaccInfo != null) {
			rankRepo.delete(getaccInfo);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public Rank addNew(Rank payload) {
		return rankRepo.save(payload);
	}

	
}
