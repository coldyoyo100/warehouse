package com.example.warehouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdtDelActionContainer {
	
	@JsonProperty("ACTION")
	private String action;
	
	@JsonProperty("MasterStock")
	private List<MStockDTO> mStock= new ArrayList<MStockDTO>();
	
	@JsonProperty("Catergory")
	private List<MCategoryDTO> category = new ArrayList<MCategoryDTO>();
	
	@JsonProperty("StockQty")
	private List<MStockQtyDTO> stockQty = new ArrayList<MStockQtyDTO>();
	
	@JsonProperty("Group")
	private List<HeadGroupDTO> group = new ArrayList<HeadGroupDTO>();
	
	@JsonProperty("DetailQty")
	private List<DetailStockQtyDTO> detailQty = new ArrayList<DetailStockQtyDTO>();
	
	@JsonProperty("SubGroup")
	private List<SubGroupDTO> subGroup = new ArrayList<SubGroupDTO>();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

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

	public List<DetailStockQtyDTO> getDetailQty() {
		return detailQty;
	}

	public void setDetailQty(List<DetailStockQtyDTO> detailQty) {
		this.detailQty = detailQty;
	}

	public List<SubGroupDTO> getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(List<SubGroupDTO> subGroup) {
		this.subGroup = subGroup;
	}
	
	
}
