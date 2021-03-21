package com.example.warehouse.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.sun.istack.NotNull;

public class MStockDTO {
	
	private Long  id;
	private String stockCode;
	private String name;
	private String category;
	private String stockGroup;
	private String totalQty;
	private String mastQtyCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStockGroup() {
		return stockGroup;
	}
	public void setStockGroup(String stockGroup) {
		this.stockGroup = stockGroup;
	}
	public String getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getMastQtyCode() {
		return mastQtyCode;
	}
	public void setMastQtyCode(String mastQtyCode) {
		this.mastQtyCode = mastQtyCode;
	}
	
}
