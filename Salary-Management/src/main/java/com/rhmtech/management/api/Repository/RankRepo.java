package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.management.api.model.Rank;
@Repository
public interface RankRepo extends JpaRepository<Rank, Long> {

}
