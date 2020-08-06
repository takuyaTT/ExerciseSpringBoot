package com.sample.springboot.reposiotories;

import com.sample.springboot.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerData,Long> {
    public Optional<CustomerData> findById(Long id);
}
