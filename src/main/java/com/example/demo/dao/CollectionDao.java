package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Collection;

@Repository
public interface CollectionDao  extends JpaRepository<Collection, Long>{
	
	public  List<Collection> findAll();
	
	public  List<Collection> findByC0001AndC0002AndC0003(int c0001, String c0002 , String c0003);
	
	
	@Query(value = "select * from collection where c0001 between ?1 and ?2 and c0002 = ?3 and c0003 = ?4" , nativeQuery = true)
	public  List<Collection> selectC0004ByDate(int startDate ,int endDate , String c0002 , String c0003);

}
