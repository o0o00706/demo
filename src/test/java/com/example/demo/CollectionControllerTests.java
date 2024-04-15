package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CollectionController;
import com.example.demo.model.CollectionModel;
import com.example.demo.model.RspCode;
import com.example.demo.schedulings.ScheduledTask;

@SpringBootTest
class CollectionControllerTests {

	
	@Autowired
	private CollectionController collectionController;
	
	
	@Test
	void correctTest() {
		
		
		CollectionModel cm = new CollectionModel("2024/03/01","2024/03/01","USD");
		
		List rsdt = new ArrayList<HashMap>();

		List rst = new ArrayList<HashMap>();
		HashMap<String, String> hst = new HashMap<String, String>();
		hst.put("date","20240301");
		hst.put("usd","31.606");
		rsdt.add(hst);
		
		RspCode  rspCodet = new RspCode("0000","成功") ;

		rst.add(rspCodet);
		rst.add(rsdt);

		List rs = collectionController.test(cm);
		RspCode  rspCode = (RspCode) rs.get(0) ;
		
		Assertions.assertEquals(rspCodet.getCode(), rspCode.getCode());
		Assertions.assertEquals(rspCodet.getMessage(), rspCode.getMessage());
		Assertions.assertEquals(rst.get(1), rs.get(1));

		
	}
	
	
	@Test
	void errorTest() {
		
		
		CollectionModel cm = new CollectionModel("2022/03/01","2024/04/01","USD");
		
		RspCode  rspCodet = new RspCode("E001","日期區間不符") ;


		List rs = collectionController.test(cm);
		
		RspCode  rspCode = (RspCode) rs.get(0) ;
		
		Assertions.assertEquals(rspCodet.getCode(), rspCode.getCode());
		Assertions.assertEquals(rspCodet.getMessage(), rspCode.getMessage());


		
	}

}
