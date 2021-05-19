package com.rhmtech.management.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhmtech.management.api.model.HeadsBenifits;

public interface BenifitsRepo extends JpaRepository<HeadsBenifits, Long> {

}
