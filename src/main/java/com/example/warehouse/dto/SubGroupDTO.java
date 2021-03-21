package com.example.warehouse.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SubGroupDTO {
	
	private Long id;
	private String hStockCode;
	private String subStockCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String gethStockCode() {
		return hStockCode;
	}
	public void sethStockCode(String hStockCode) {
		this.hStockCode = hStockCode;
	}
	public String getSubStockCode() {
		return subStockCode;
	}
	public void setSubStockCode(String subStockCode) {
		this.subStockCode = subStockCode;
	}
	
	
}
