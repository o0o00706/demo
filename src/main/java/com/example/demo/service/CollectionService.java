package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CollectionDao;
import com.example.demo.entity.Collection;

@Service
public class CollectionService {
	
	@Autowired 
	private  CollectionDao cd ;
	
	public  List<Collection> findByC0001andC0002AndC0003 (int c0001, String c0002 , String c0003){
		return cd.findByC0001AndC0002AndC0003(c0001 , c0002 , c0003);
	}
	
	public  List<Collection> selectC0004ByDate (int startDate ,int endDate , String c0002 , String c0003){
		return cd.selectC0004ByDate(startDate , endDate , c0002 , c0003);
	}
	
	public Collection insert (Collection c){
		
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
//		 System.out.println("sys date = " + dateFormat.format(calendar.getTime()));	
		c.setCrddt(Integer.valueOf(dateFormat.format(calendar.getTime())));
		
		return cd.save(c);
//		return c ;
	}
		
    
}
