package com.ra.uplaod_file.controller;

import com.ra.uplaod_file.dto.request.ProductRequest;
import com.ra.uplaod_file.model.Product;
import com.ra.uplaod_file.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/products")
@PropertySource("classpath:upload_file.properties")
public class ProductController
{
	@Value("${file-upload}")
	private String fileUpload;
	
	@Autowired
	private IProductService productService;
	
	@GetMapping
	public String index(Model model)
	{
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
	@GetMapping("/add")
	public String viewAdd()
	{
		return "add_product";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute ProductRequest productRequest)
	{
		MultipartFile multipartFile = productRequest.getImage();
		String fileName = multipartFile.getOriginalFilename();
		try
		{
			FileCopyUtils.copy(productRequest.getImage().getBytes(), new File(fileUpload + fileName));
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		Product product = new Product(productRequest.getId(), productRequest.getName(),
				  productRequest.getDescription(), fileName);
		productService.save(product);
		return "redirect:/products";
	}
	
}
