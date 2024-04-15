package com.example.demo.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(CollectionId.class)
@Table(name = "COLLECTION")
public class Collection implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "c0001")
    private Integer c0001;
	@Id
	@Column(name = "c0002")
    private String c0002;
	@Id
	@Column(name = "c0003")
    private String c0003;
	@Column(name = "c0004")
    private String c0004;
	@Column(name = "crddt")
    private Integer crddt;
	@Column(name = "crdtm")
    private Integer crdtm;
	@Column(name = "crdur")
    private String crdur;
	@Column(name = "upddt")
    private Integer upddt;
	@Column(name = "updtm")
    private Integer updtm;
	@Column(name = "updur")
    private String updur;
	
	
	public Integer getC0001() {
		return c0001;
	}
	public void setC0001(Integer c0001) {
		this.c0001 = c0001;
	}
	public String getC0002() {
		return c0002;
	}
	public void setC0002(String c0002) {
		this.c0002 = c0002;
	}
	public String getC0003() {
		return c0003;
	}
	public void setC0003(String c0003) {
		this.c0003 = c0003;
	}
	public String getC0004() {
		return c0004;
	}
	public void setC0004(String c0004) {
		this.c0004 = c0004;
	}
	public Integer getCrddt() {
		return crddt;
	}
	public void setCrddt(Integer crddt) {
		this.crddt = crddt;
	}
	public Integer getCrdtm() {
		return crdtm;
	}
	public void setCrdtm(Integer crdtm) {
		this.crdtm = crdtm;
	}
	public String getCrdur() {
		return crdur;
	}
	public void setCrdur(String crdur) {
		this.crdur = crdur;
	}
	public Integer getUpddt() {
		return upddt;
	}
	public void setUpddt(Integer upddt) {
		this.upddt = upddt;
	}
	public Integer getUpdtm() {
		return updtm;
	}
	public void setUpdtm(Integer updtm) {
		this.updtm = updtm;
	}
	public String getUpdur() {
		return updur;
	}
	public void setUpdur(String updur) {
		this.updur = updur;
	}
    
   
    
    
}
