package com.example.warehouse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_group")
public class SubGroup implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="h_stock_code")
	private String hStockCode;
	
	@Column(name="sub_stock_code")
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
