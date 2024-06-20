package com.demo.arselCRUD.service;

import com.demo.arselCRUD.entity.Products;
import com.demo.arselCRUD.pojo.ProductsPojo;
import com.demo.arselCRUD.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Integer id) {
        Optional<Products> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Products saveProduct(ProductsPojo product) {
        Products data = new Products();
        data.setAmount(product.getAmount());
        data.setProductName(product.getProductName());
        data.setWaktuUpdate(new Date());

        return productRepository.save(data);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
