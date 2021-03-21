package com.example.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.sun.istack.NotNull;

@Entity
@Table(name = "m_stock")
//@SequenceGenerator(name="MSTOCK_SEQ_ID", sequenceName = "MSTOCK_SEQ_ID", allocationSize = 1)
public class MStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="stock_code")
	private String stockCode;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer category;
	
	@Column(name="stock_group")
	private String stockGroup;
	
	@NotNull
	@Column(name="total_qty")
	private Integer totalQty;
	
	@NotNull
	@Column(name="mast_qty_code")
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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getStockGroup() {
		return stockGroup;
	}

	public void setStockGroup(String stockGroup) {
		this.stockGroup = stockGroup;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public String getMastQtyCode() {
		return mastQtyCode;
	}

	public void setMastQtyCode(String mastQtyCode) {
		this.mastQtyCode = mastQtyCode;
	}

	
}
