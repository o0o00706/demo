package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Collection;
import com.example.demo.model.CollectionModel;
import com.example.demo.model.RspBody;
import com.example.demo.model.RspCode;
import com.example.demo.service.CollectionService;

@RestController
public class CollectionController   {

	
	@Autowired 
	private CollectionService cs ;
	
	@RequestMapping(value = "/forex", method = RequestMethod.POST)
	public List test(@RequestBody CollectionModel collectionModel) {

		
		List rs = new ArrayList<HashMap>();

		RspCode  rspCode = new RspCode("0000","成功") ;
		RspBody  rspBody = new RspBody();

		Calendar calendarMax= Calendar.getInstance();
		Calendar calendarMix= Calendar.getInstance();
		calendarMax.add(Calendar.DAY_OF_YEAR, -1);
		calendarMix.add(Calendar.YEAR, -1);
		Date maxD = calendarMax.getTime();
		Date mixD = calendarMix.getTime();
	

		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyyMMdd");
		
		System.out.println("maxD = " + dateFormat.format(maxD) );
		System.out.println("mixD = " + dateFormat.format(mixD));

		String startDate  = collectionModel.getStartDate();
		String endDate  = collectionModel.getEndDate();
		String currency  = collectionModel.getCurrency().toUpperCase();
		List rsd = new ArrayList<HashMap>();

	    try {
			
			Date ds = dateFormat.parse(startDate);
			Date de = dateFormat.parse(endDate);
			
			int days1 = (int) ((ds.getTime() - mixD.getTime()) / (1000*3600*24));
			System.out.println("days = " + days1);
			
			int days2 = (int) ((maxD.compareTo(de)));
			int days3 = (int) ((maxD.compareTo(ds)));
			System.out.println("days2 = " + days2);
			System.out.println("days3 = " + days3);

			if(days1 <0 || days1 >= 365 || days2 <=0 || days3 <=0) {
				rspCode.setCode("E001");
				rspCode.setMessage("日期區間不符");
				rs.add(rspCode);
		        return rs;

			}else {

				startDate = new SimpleDateFormat("yyyyMMdd").format(ds);
				endDate = new SimpleDateFormat("yyyyMMdd").format(de);
				
				List<Collection> cls = cs.selectC0004ByDate(Integer.parseInt(startDate), Integer.parseInt(endDate), currency, "NTD");
				System.out.println("cls = " + cls);
				
				for (int i = 0; i < cls.size(); i++) {
					HashMap<String, String> hs = new HashMap<String, String>();
					hs.put("date", cls.get(i).getC0001().toString());
					hs.put("usd", cls.get(i).getC0004());
					rsd.add(hs);
				}
				
				
			}
	    	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			rspCode.setCode("E002");
			rspCode.setMessage("資料格式不符");
			rs.add(rspCode);
	        return rs;

		}  

	
	    rs.add(rspCode);
	    rs.add(rsd);
    
        return rs;

    }

		
		
    
    
	
	
}
