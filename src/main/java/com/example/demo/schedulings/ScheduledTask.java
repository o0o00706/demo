package com.example.demo.schedulings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Collection;
import com.example.demo.service.CollectionService;

@Component
public class ScheduledTask   {

	
	@Autowired 
	private CollectionService cs ;
	
//    @Scheduled(fixedRate = 100000)
    @Scheduled(cron = "0 0 18 * * ?")
    public void collection() {


    	String url2 = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates" ;
		
    	HttpURLConnection conn = null;

		try {
			
				
			StringBuilder result = new StringBuilder();
			URL url;
		
			url = new URL(url2);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
	      try (BufferedReader reader = new BufferedReader(
	    		new InputStreamReader(conn.getInputStream()))) {
			    	  for (String line; (line = reader.readLine()) != null; ) {
			    		  result.append(line);
			    	  }
	      		}
	      	      
	      JSONArray jsonArray = new JSONArray(result.toString());	    
	      
	      for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsnobject = (JSONObject) jsonArray.get(i);

				Collection collection = new Collection();
				collection.setC0001(Integer.parseInt(jsnobject.get("Date").toString()));
				
				//USD/NTD
				collection.setC0002("USD");
				collection.setC0003("NTD");
				collection.setC0004(jsnobject.get("USD/NTD").toString());
				cs.insert(collection);
				
				//RMB/NTD
				collection.setC0002("RMB");
				collection.setC0003("NTD");
				collection.setC0004(jsnobject.get("RMB/NTD").toString());
				cs.insert(collection);	
	
				//EUR/USD
				collection.setC0002("EUR");
				collection.setC0003("USD");
				collection.setC0004(jsnobject.get("EUR/USD").toString());
				cs.insert(collection);				
				
				//USD/JPY
				collection.setC0002("USD");
				collection.setC0003("JPY");
				collection.setC0004(jsnobject.get("USD/JPY").toString());
				cs.insert(collection);	
				
				//GBP/USD
				collection.setC0002("GBP");
				collection.setC0003("USD");
				collection.setC0004(jsnobject.get("GBP/USD").toString());
				cs.insert(collection);			
				
				//AUD/USD
				collection.setC0002("AUD");
				collection.setC0003("USD");
				collection.setC0004(jsnobject.get("AUD/USD").toString());
				cs.insert(collection);	
				
				//USD/HKD
				collection.setC0002("USD");
				collection.setC0003("HKD");
				collection.setC0004(jsnobject.get("USD/HKD").toString());
				cs.insert(collection);	
				
				//USD/RMB
				collection.setC0002("USD");
				collection.setC0003("RMB");
				collection.setC0004(jsnobject.get("USD/RMB").toString());
				cs.insert(collection);	
				
				
				//USD/ZAR
				collection.setC0002("USD");
				collection.setC0003("ZAR");
				collection.setC0004(jsnobject.get("USD/ZAR").toString());
				cs.insert(collection);
				
				//NZD/USD
				collection.setC0002("NZD");
				collection.setC0003("USD");
				collection.setC0004(jsnobject.get("NZD/USD").toString());
				cs.insert(collection);
				
				
		}
	      


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.disconnect();
		
		}
		
        
    }

		
		
    
    
	
	
}
