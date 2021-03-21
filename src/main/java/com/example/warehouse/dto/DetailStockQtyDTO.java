package com.example.warehouse.dto;


public class DetailStockQtyDTO {

	private Long id;
	private String stockQtyId;
	private String stockCode;
	private String color;
	private String qty;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStockQtyId() {
		return stockQtyId;
	}
	public void setStockQtyId(String stockQtyId) {
		this.stockQtyId = stockQtyId;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	
}
