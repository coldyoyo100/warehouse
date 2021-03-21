package com.example.warehouse.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehouse.dto.DetailStockQtyDTO;
import com.example.warehouse.dto.HeadGroupDTO;
import com.example.warehouse.dto.InsertActionContainer;
import com.example.warehouse.dto.MCategoryDTO;
import com.example.warehouse.dto.MStockDTO;
import com.example.warehouse.dto.MStockQtyDTO;
import com.example.warehouse.dto.SubGroupDTO;
import com.example.warehouse.enums.StockExcelEnum;
import com.example.warehouse.model.DetailStockQty;
import com.example.warehouse.model.HeadGroup;
import com.example.warehouse.model.MCategory;
import com.example.warehouse.model.MStock;
import com.example.warehouse.model.MStockQty;
import com.example.warehouse.model.SubGroup;
import com.example.warehouse.repository.DetailStockQtyRepo;
import com.example.warehouse.repository.HeadGroupRepo;
import com.example.warehouse.repository.MCategoryRepo;
import com.example.warehouse.repository.MStockQtyRepo;
import com.example.warehouse.repository.MStockRepo;
import com.example.warehouse.repository.SubGroupRepo;

@Service
public class WarehouseService {
	
	Logger log = LoggerFactory.getLogger(WarehouseService.class);
	
	@Autowired
	MStockRepo stockRepo;
	
	@Autowired
	MCategoryRepo categoryRepo;
	
	@Autowired
	HeadGroupRepo groupRepo;
	
	@Autowired
	SubGroupRepo subGroupRepo;
	
	@Autowired
	MStockQtyRepo stockQtyRepo;
	
	@Autowired
	DetailStockQtyRepo detailQtyRepo;
	
	
	public Map<String, Object> checkValue(InsertActionContainer iac) {
		Map<String, Object> objList = new HashMap<String, Object>();
		List<?> check = new ArrayList<>();
		check = iac.getmStock();
		if(check.size() > 0)  objList.put("MStock", (Object) iac.getmStock());
		
		check = iac.getCategory();
		if(check.size() > 0) objList.put("Category", (Object) iac.getCategory());
		
		check = iac.getGroup();
		if(check.size() > 0) objList.put("HeadGroup", (Object) iac.getGroup());
		
		check = iac.getStockQty();
		if(check.size() > 0) objList.put("MStockQty", (Object) iac.getStockQty());
		
//		insertData(objList);
		
		return objList;
	}
	
	public void insertData(Map<String, Object> objList ) throws Exception {
		if(objList.isEmpty()) {
			System.out.println("data kosong, tidak ada action Insert");
		}else {
			for(Entry<String, Object> map : objList.entrySet()) {
				String key = map.getKey();
				Object obj = map.getValue();
				if(key.equals("MStock")){
					MStock stock;
					List<MStockDTO> listDto = (List<MStockDTO>) obj;
					
					for(MStockDTO dto : listDto) {
						stock = new MStock();
						
						stock.setId(dto.getId() );
						stock.setName(dto.getName());
						stock.setStockCode(dto.getStockCode());
						stock.setStockGroup(dto.getStockGroup());
						stock.setTotalQty(Integer.valueOf(dto.getTotalQty()));
						stock.setMastQtyCode(dto.getMastQtyCode());
						
						stockRepo.save(stock);
					 }
				}else if(key.equals("Category")) {
					MCategory category;
					List<MCategoryDTO> listDto = (List<MCategoryDTO>) obj;
					
					for(MCategoryDTO dto : listDto) {
						category = new MCategory();
						category.setId(dto.getId());
						category.setCategoryName(dto.getCategoryName());
						
						categoryRepo.save(category);
					}
				}else if(key.equals("HeadGroup")) {
					HeadGroup headGroup;
					List<HeadGroupDTO> listDto = (List<HeadGroupDTO>) obj;
					
					for(HeadGroupDTO dto : listDto) {
						headGroup = new HeadGroup();
						headGroup.setId(dto.getId());
						headGroup.setStockCode(dto.getStockCode());
						headGroup.setStockName(dto.getStockName());
						
						groupRepo.save(headGroup);
						insertSubGroup(dto.getSubList());
					}
				}else if(key.equals("MStockQty")) {
					MStockQty stockQty;
					List<MStockQtyDTO> listDto = (List<MStockQtyDTO>) obj;
					
					for(MStockQtyDTO dto : listDto) {
						stockQty = new MStockQty();
						stockQty.setId(dto.getId());
						stockQty.setStockCode(dto.getStockCode());
						stockQty.setTotalQty(dto.getTotalQty());
						stockQty.setColorInfo(dto.getColorInfo());
						stockQty.setDetStockCode(dto.getDetStockCode());
						
						stockQtyRepo.save(stockQty);
						insertDetailQty( dto.getDetailQty());
					}
				}
			}
		}
	}
	
	public void insertSubGroup(List<SubGroupDTO> subGroupDto) {
		SubGroup subGroup;
		for(SubGroupDTO subDto : subGroupDto) {
			subGroup = new SubGroup ();
			
			subGroup.sethStockCode(subDto.gethStockCode());
			subGroup.setSubStockCode(subDto.getSubStockCode());
			subGroupRepo.save(subGroup);
		}
	}
	
	public void insertDetailQty(List<DetailStockQtyDTO> detailQty) {
		DetailStockQty detStockQty;
		for(DetailStockQtyDTO dto : detailQty) {
			detStockQty = new DetailStockQty();
			
			detStockQty.setStockQtyId(dto.getStockQtyId());
//			stockQty.setStockCode(null);
			detStockQty.setQty(Integer.valueOf(dto.getQty()));
			detStockQty.setColor(dto.getColor());
			detailQtyRepo.save(detStockQty);
		}
	}
	
	
	public void updateData(Map<String, String> jsonStr) {
		
		Long id = Long.parseLong(jsonStr.get("id"));
		MStock stock = stockRepo.searchId(id);
		
		String name = jsonStr.get("name");
		int qty = Integer.valueOf(jsonStr.get("totalQty"));
		stock.setName(name);
		stock.setTotalQty(qty);
		
		stockRepo.save(stock);
	}
	
	public void deleteData(String id) {
		
		stockRepo.deleteById(Long.parseLong(id));
		
//		stockRepo.save(stock);
	}
	
	public void genereateReport() throws Exception {
		
		List<MStock> stockList = stockRepo.getAllStock();
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Stock Info");
		
		Font headerFont = workbook.createFont();
//		headerFont.setBoldweight((short) 2);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		
		//create Header Row
		Row headerRow = sheet.createRow(0);
		
		int columnlength = StockExcelEnum.values().length;
		StockExcelEnum stockEnum = null;
		
		for (int i = 0; i < columnlength; i++) {
		  Cell cell = headerRow.createCell(i);
		  
		  stockEnum = (StockExcelEnum) StockExcelEnum.values()[i];
				  
		  cell.setCellValue(stockEnum.getHeaderColumn());
		  cell.setCellStyle(headerCellStyle);
		}
		
		// Resize all columns to fit the content size
		for (int i = 0; i < columnlength; i++) {
		  sheet.autoSizeColumn(i);
		}
		
		// Create Other Rows Value 
		int index = 1;
		
		for (MStock stock : stockList) {
			int rowCount = 0;
		  Row row = sheet.createRow(index++);
		  row.createCell(rowCount++).setCellValue(stock.getStockCode());
		  row.createCell(rowCount++).setCellValue(stock.getName());
		  row.createCell(rowCount++).setCellValue(stock.getCategory());
		  row.createCell(rowCount++).setCellValue(stock.getTotalQty());
		  row.createCell(rowCount++).setCellValue(stock.getStockGroup());
		}
		
//		ByteArrayOutputStream fileOut = new ByteArrayOutputStream();  //for generate OnTheFLy memory
		//ubah ke byte, dan attach to email
		
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\J\\Desktop\\testing_excel.xlsx");
	    		
		workbook.write(fileOut);
		fileOut.close();
	}
	
	
	
}
