package com.revature.inventory.service.impl;

import com.revature.inventory.dao.ProductDao;
import com.revature.inventory.exceptions.NoProductListFoundException;
import com.revature.inventory.exceptions.ProductNotFoundException;
import com.revature.inventory.exceptions.UnsuccessfulDeleteOperationException;
import com.revature.inventory.exceptions.UnsuccessfulSaveOperationException;
import com.revature.inventory.model.Product;
import com.revature.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public Product createProduct(Product product) {
		try {return productDao.save(product); 
		}
		catch(IllegalArgumentException ex){
		throw new UnsuccessfulSaveOperationException(ex.getMessage());
		}
	}

	@Override
	public List<Product> findAllProducts() {
		List <Product> products = productDao.findAll();
		if (products.isEmpty()) {
			throw new NoProductListFoundException("No products found");
		}
		return products;
	}

	@Override
	public Product findProductById(Long id) {
		return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}

	@Override
	public Product updateProduct(Product product) {
		try {
		return productDao.save(product);
		}
		catch(IllegalArgumentException ex) {
			throw new UnsuccessfulSaveOperationException(ex.getMessage());	
		}
	}
		
	@Override
	public void deleteProductById(Long id) {
		try {productDao.deleteById(id);	
		}
		catch(IllegalArgumentException ex){
			throw new UnsuccessfulDeleteOperationException(ex.getMessage());
		}		

	}
}
