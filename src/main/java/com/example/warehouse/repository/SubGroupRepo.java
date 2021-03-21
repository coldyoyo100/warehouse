package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.warehouse.model.SubGroup;

@Repository
@EnableJpaRepositories
public interface SubGroupRepo extends JpaRepository<SubGroup, Long> {

}
