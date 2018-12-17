package com.project.ffs.service;

import java.util.Optional;

import com.project.ffs.model.Product;
import com.project.ffs.model.Warehouse;

public class WarehouseService {

	Warehouse warehouse = Warehouse.getInstance();

	public boolean add(Product product) {
		return warehouse.getProducts().add(product);

	}

	public boolean delete(String productName) {

		Optional<Product> product = warehouse.getProducts().stream().filter(p -> productName.equals(p.getName()))
				.findFirst();
		if (product.isPresent()) {
			warehouse.getSoldProducts().add(product.get());
			return warehouse.getProducts().remove(product.get());
		} else {
			return false;
		}

	}

	public boolean deleteAll() {
		if (!warehouse.getProducts().isEmpty()) {
			warehouse.getProducts().clear();
		}

		return warehouse.getProducts().isEmpty();
	}

	public String getReport() {
		StringBuilder builder = new StringBuilder();
		builder.append("product in stock \n");
		for (Product product : warehouse.getProducts()) {
			builder.append(product.getName());
			builder.append("\n");
		}
		builder.append("*----------------------------* \n");
		builder.append("product out stock \n");
		for (Product product : warehouse.getSoldProducts()) {
			builder.append(product.getName());
			builder.append("\n");
		}
		
		return builder.toString();
	}

}
