package com.example.warehouse.enums;

public enum StockExcelEnum {
	
	STOCK_CODE("Stock Code"),
	NAME("Name"),
	CATEGORY("Category"),
	TOTAL_QTY("Total Qty"),
	STOCK_GROUP("Stock Group");
	
	private StockExcelEnum(String headerColumn) {
		this.headerColumn = headerColumn;
	}

	private final String headerColumn;

	public String getHeaderColumn() {
		return this.headerColumn;
	}
}
