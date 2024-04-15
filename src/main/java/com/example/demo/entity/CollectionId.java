package com.example.demo.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class CollectionId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "c0001")
    private Integer c0001;
	@Column(name = "c0002")
    private String c0002;
	@Column(name = "c0003")
    private String c0003;
	
	
   
    
    
}
