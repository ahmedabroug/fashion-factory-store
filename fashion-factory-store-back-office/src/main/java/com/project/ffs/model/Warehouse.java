package com.project.ffs.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.AccessLevel;

@Getter
public class Warehouse {
	static final  String MANAGER_NAME = "bob";

	@Getter(AccessLevel.NONE)
	private static volatile Warehouse instance = null;
	private List<Product> products = new ArrayList<>();
	private List<Product> soldProducts = new ArrayList<>();
	private Manager manager = new Manager(MANAGER_NAME);

	public Warehouse() {
		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}
	
	public static Warehouse getInstance() {
		if(instance == null) {
			synchronized(Warehouse.class) {
				if(instance == null) {
					instance = new Warehouse();
				}
			}
		}
		
		return instance;
	}
	

}
