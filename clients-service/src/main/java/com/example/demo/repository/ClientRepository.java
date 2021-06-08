package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TblClient;


@Repository
public interface ClientRepository extends JpaRepository<TblClient, Long>{

	List<TblClient> findByNameIgnoreCase(String name);

	List<TblClient> findByDobBetween(Date fromDate, Date toDate);
	
	@Query(nativeQuery = true,value = "SELECT * FROM TBL_CLIENT  WHERE DOB>=?1")
	List<TblClient> findByDobAfter(Date fromDate);
}
