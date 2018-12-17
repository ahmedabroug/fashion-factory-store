package com.project.ffs.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.project.ffs.model.Product;
import com.project.ffs.service.ClientService;
import com.project.ffs.service.ManagerService;
import com.project.ffs.service.WarehouseService;

public class OperationServiceTest {
	
	final static String CLIENT_NAME = "smith";
	final static String PRODUCT_NAME_SHOES = "shose";
	final static String PRODUCT_NAME_JEANS = "jeans";
	final static String PRODUCT_NAME_JACKET = "jacket";
	final static String MANAGER_NAME = "bob";


	
	@Test
	public void whenManagerStockProduct_ClientShouldByeProduct() {
		
				
		ManagerService manager = new ManagerService(new WarehouseService());
		
		manager.clearWarehouse();
		
		manager.stock(Product.builder().name(PRODUCT_NAME_SHOES).build());
		manager.stock(Product.builder().name(PRODUCT_NAME_JACKET).build());
		manager.stock(Product.builder().name(PRODUCT_NAME_JEANS).build());		
		ClientService clientService = new ClientService(manager);
		
		assertThat(clientService.buy(PRODUCT_NAME_SHOES), is(true));
		
		System.out.println(manager.check());
		
		

	}
	
	@Test
	public void whenManagerStockProduct_ClientShouldNotByeProduct() {
				
		ManagerService manager = new ManagerService(new WarehouseService());
		
		manager.clearWarehouse();
		
		ClientService clientService = new ClientService(manager);

		assertThat(clientService.buy(PRODUCT_NAME_SHOES), is(false));
		
		System.out.println(manager.check());
		
	}

}
