package com.sample.boot.repositories;

import com.sample.boot.CostomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostomerRepository extends JpaRepository<CostomerData, Long> {
	
}