package com.example.warehouse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="detailStockQty")
//@SequenceGenerator(name="DET_STOCK_SEQ_ID", allocationSize =1, sequenceName = "DET_STOCK_SEQ_ID")
public class DetailStockQty implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailId;

	@Column(name="stock_qty_id")
	private String stockQtyId;
	
	@Column(name="stock_code")
	private String stockCode;
	
	@NotNull
	@Column(name="color")
	private String color;
	
	@NotNull
	@Column(name="qty")
	private Integer qty;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
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

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	
	
}
