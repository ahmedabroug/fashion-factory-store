package com.project.ffs.service;

public class ClientService {
	
	ManagerService service;
	
	public ClientService (ManagerService service) {
		this.service = service;
	}
	
	public boolean buy(String product) {
		return service.sell(product);
	}

}
