package com.demo.arselCRUD.service;

import com.demo.arselCRUD.entity.Products;
import com.demo.arselCRUD.pojo.ProductsPojo;
import com.demo.arselCRUD.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService {

    @Autowired
    private ProductsRepository productsRepository;

//    public Products saveProducts(ProductsPojo product) {
//        Products data = new Products();
//        data.setNamaBarang(product.getNamaBarang());
//        data.setAmount(product.getAmount());
//        data.setWaktuUpdate(new Date());
//        productsRepository.save(data);
//
//        return data;
//    }

//    public Transactions saveTransactions(TransactionsPojo transaction) {
//        Products data = new Products();
//        data.setNamaBarang(product.getNamaBarang());
//        data.setAmount(product.getAmount());
//        data.setWaktuUpdate(new Date());
//        productsRepository.save(data);
//
//        return data;
//    }
}
