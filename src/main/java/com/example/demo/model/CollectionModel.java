package com.example.demo.model;

public class CollectionModel {
	

    private String startDate;

    private String endDate;

    private String currency;

    
    
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public CollectionModel (String startDate , String endDate , String currency) {
		this.startDate = startDate ;
		this.endDate = endDate ;
		this.currency = currency ;		
	}
    
    
}
