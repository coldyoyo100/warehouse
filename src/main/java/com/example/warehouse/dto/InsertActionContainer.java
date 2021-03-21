package com.example.warehouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertActionContainer {
	@JsonProperty("MasterStock")
	private List<MStockDTO> mStock= new ArrayList<MStockDTO>();
	
	@JsonProperty("Category")
	private List<MCategoryDTO> category = new ArrayList<MCategoryDTO>();
	
	@JsonProperty("StockQty")
	private List<MStockQtyDTO> stockQty = new ArrayList<MStockQtyDTO>();
	
	@JsonProperty("Group")
	private List<HeadGroupDTO> group = new ArrayList<HeadGroupDTO>();

	public List<MStockDTO> getmStock() {
		return mStock;
	}

	public void setmStock(List<MStockDTO> mStock) {
		this.mStock = mStock;
	}

	public List<MCategoryDTO> getCategory() {
		return category;
	}

	public void setCategory(List<MCategoryDTO> category) {
		this.category = category;
	}

	public List<MStockQtyDTO> getStockQty() {
		return stockQty;
	}

	public void setStockQty(List<MStockQtyDTO> stockQty) {
		this.stockQty = stockQty;
	}

	public List<HeadGroupDTO> getGroup() {
		return group;
	}

	public void setGroup(List<HeadGroupDTO> group) {
		this.group = group;
	}
	
	
}
