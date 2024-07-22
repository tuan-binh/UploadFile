package com.ra.uplaod_file.service.impl;

import com.ra.uplaod_file.model.Product;
import com.ra.uplaod_file.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService
{
	private static final List<Product> products = new ArrayList<>();
	
	@Override
	public List<Product> findAll()
	{
		return products;
	}
	
	@Override
	public void save(Product product)
	{
		products.add(product);
	}
	
}
