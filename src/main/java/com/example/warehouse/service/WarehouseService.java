package com.example.warehouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
				if(key.equals("MStock")){
					MStock stock = new MStock();
					MStockDTO dto = (MStockDTO) map.getValue();
					
					stock.setId(dto.getId() );
					stock.setName(dto.getName());
					stock.setStockCode(dto.getStockCode());
					stock.setStockGroup(dto.getStockGroup());
					stock.setTotalQty(Integer.valueOf(dto.getTotalQty()));
					stock.setMastQtyCode(dto.getMastQtyCode());
					
					stockRepo.save(stock);
				}else if(key.equals("Category")) {
					MCategory category = new MCategory();
					MCategoryDTO dto = (MCategoryDTO) map.getValue();
					
					category.setId(dto.getId());
					category.setCategoryName(dto.getCategoryName());
					
					categoryRepo.save(category);
				}else if(key.equals("HeadGroup")) {
					HeadGroup headGroup = new HeadGroup(); 
					HeadGroupDTO dto = (HeadGroupDTO) map.getValue();
					//dto.getId();
					headGroup.setStockCode(dto.getStockCode());
					headGroup.setStockName(dto.getStockName());
					
					groupRepo.save(headGroup);
					insertSubGroup(dto.getSubList());
				}else if(key.equals("MStockQty")) {
					MStockQty stockQty = new MStockQty();
					MStockQtyDTO dto = (MStockQtyDTO) map.getValue();
					//dto.getId();
					stockQty.setStockCode(dto.getStockCode());
					stockQty.setTotalQty(dto.getTotalQty());
					stockQty.setColorInfo(dto.getColorInfo());
					
					stockQtyRepo.save(stockQty);
					insertDetailQty( dto.getDetailQty());
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
		
//		repo save
	}
	
	
	
}
