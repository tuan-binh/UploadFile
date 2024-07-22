package com.ra.uplaod_file.service;

import com.ra.uplaod_file.model.Product;

import java.util.List;

public interface IProductService
{
	List<Product> findAll();
	void save(Product product);
}
