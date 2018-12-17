package com.project.ffs.service;

import com.project.ffs.model.Product;

public class ManagerService {
	
	private WarehouseService service;
	
	public ManagerService(WarehouseService service) {
		this.service = service;
	}
	
	public boolean stock(Product product) {

		return service.add(product);
	}

	public boolean sell(String product) {
		return service.delete(product);		
	}
	
	public boolean clearWarehouse() {
		return service.deleteAll();		
	}
	
	public String check() {
		
		return service.getReport();
		
	}

}
