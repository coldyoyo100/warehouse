package com.example.warehouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeadGroupDTO {
	
	private Long id;
	private String stockCode;
	private String stockName;
	
	@JsonProperty("Sub_List")
	private List<SubGroupDTO> subList = new ArrayList<SubGroupDTO>();
	
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
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public List<SubGroupDTO> getSubList() {
		return subList;
	}
	public void setSubList(List<SubGroupDTO> subList) {
		this.subList = subList;
	}
	
	
}
