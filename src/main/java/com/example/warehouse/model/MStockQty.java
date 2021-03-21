package com.example.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="m_stock_qty")
//@SequenceGenerator(name = "STOCK_QTY_SEQ_ID", allocationSize = 1, sequenceName = "STOCK_QTY_SEQ_ID")
public class MStockQty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="stock_code")
	private String stockCode;
	
	@Column(name="det_stock_code")
	private String detStockCode;
	
	@Column(name="total_qty")
	private String totalQty;
	
	@Column(name="color_info")
	private String colorInfo;

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

	public String getDetStockCode() {
		return detStockCode;
	}

	public void setDetStockCode(String detStockCode) {
		this.detStockCode = detStockCode;
	}

	public String getColorInfo() {
		return colorInfo;
	}

	public void setColorInfo(String colorInfo) {
		this.colorInfo = colorInfo;
	}
	
	
	
}
