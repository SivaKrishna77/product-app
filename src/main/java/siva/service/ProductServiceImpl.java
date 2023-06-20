package siva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import siva.entity.Product;
import siva.exceptions.ProductNotFoundException;
import siva.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository=repository;
	}

	@Override
	public List<Product> products() {
		return repository.findAll();

	}

	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Integer prodId, Product product) {
		Product productById = findProductById(prodId);
		productById=findProductById(prodId);
		productById.setPname(product.getPname());
		productById.setDescription(product.getDescription());
		productById.setPrice(product.getPrice());
		
		repository.save(productById);
		return productById;
	}

	@Override
	public void deleteProduct(Integer prodId) {
		Product productById=findProductById(prodId);
		repository.delete(productById);
	}

	@Override
	public Product findProductById(Integer proId) {
		return repository.findById(proId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not found with ID : " + proId));
	}


}
