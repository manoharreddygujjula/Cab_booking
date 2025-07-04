package com.manohar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manohar.entity.Driver;
@Repository
public interface DriverDao extends JpaRepository<Driver,Integer> {
	@Query("from Driver d where d.rating>=4.5 AND d.available='true'")
	public List<Driver> viewBestDriver();
	
	@Query("from Driver d where d.available=true")
	public List<Driver> findByAvailable();
}
