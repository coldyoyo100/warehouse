package com.example.warehouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MStockQtyDTO {
	
	private Long id;
	private String stockCode;
	private String totalQty;
	private String colorInfo;
	
	@JsonProperty("Detail_Qty")
	private List<DetailStockQtyDTO> detailQty = new ArrayList<DetailStockQtyDTO>();
	
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
	public String getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getColorInfo() {
		return colorInfo;
	}
	public void setColorInfo(String colorInfo) {
		this.colorInfo = colorInfo;
	}
	public List<DetailStockQtyDTO> getDetailQty() {
		return detailQty;
	}
	public void setDetailQty(List<DetailStockQtyDTO> detailQty) {
		this.detailQty = detailQty;
	}
	
	
	
}
