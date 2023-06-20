package siva.service;

import java.util.List;

import siva.entity.Product;

public interface ProductService {
	
	List<Product> products();
	
	Product addProduct(Product product);
	
	Product updateProduct(Integer prodId,Product product);
	
	void deleteProduct(Integer prodId);
	
	Product findProductById(Integer prodId);
}