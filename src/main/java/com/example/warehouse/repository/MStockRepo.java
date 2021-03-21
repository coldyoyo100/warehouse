package com.example.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.warehouse.model.MStock;

@Repository
@EnableJpaRepositories
public interface MStockRepo extends JpaRepository<MStock, Long>  {
	
	@Query(value = "Select stock.* From m_stock stock ",  nativeQuery = true)
	List<MStock> getAllStock();
	
	@Query(value = "Select stock.* From m_stock stock WHERE stock.id = :id",  nativeQuery = true)
	MStock searchId(Long id);
	
	@Query(value = "DELETE m_stock stock WHERE stock.id = :id",  nativeQuery = true)
	void deleteById(Long id);
}
