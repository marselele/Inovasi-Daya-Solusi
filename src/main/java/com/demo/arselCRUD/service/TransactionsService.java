package com.demo.arselCRUD.service;

import com.demo.arselCRUD.entity.Products;
import com.demo.arselCRUD.entity.Status;
import com.demo.arselCRUD.entity.Transactions;
import com.demo.arselCRUD.pojo.TransactionsPojo;
import com.demo.arselCRUD.pojo.TransactionsResponsePojo;
import com.demo.arselCRUD.repository.ProductsRepository;
import com.demo.arselCRUD.repository.StatusRepository;
import com.demo.arselCRUD.repository.TransactionsRepository;
import com.demo.arselCRUD.utils.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TransactionsService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    StatusRepository statusRepository;

    public ResponseEntity<MessageModel> getAllTransactions() {
        MessageModel msg = new MessageModel();
        List<TransactionsResponsePojo> responses = new ArrayList<>();
        List<Transactions> datas = transactionsRepository.findAll();
        for (Transactions data : datas) {
            TransactionsResponsePojo response = new TransactionsResponsePojo();
            response.setId(data.getId());
            response.setProductID(data.getProduct().getId());
            response.setProductName(data.getProduct().getProductName());
            response.setAmount(data.getProduct().getAmount());
            response.setCustomerName(data.getCustomerName());
            response.setTransactionDate(data.getTransactionDate());
            response.setCreatedOn(data.getCreateOn());
            response.setCreatedBy(data.getCreateBy());
            responses.add(response);
        }
        List<Status> status = statusRepository.findAll();
        msg.setData(datas.isEmpty() ? new ArrayList<>() : responses);
        msg.setStatus(status.isEmpty() ? new ArrayList<>() : status);
        return ResponseEntity.ok().body(msg);
    }

    public Transactions getTransactionById(int id) {
        Optional<Transactions> transaction = transactionsRepository.findById(id);
        return transaction.orElse(null);
    }

    public Transactions saveTransaction(TransactionsPojo transaction) {
        try {
            Products product = productsRepository.getProductById(transaction.getProductID());
            Transactions trx = new Transactions();
            if (product != null && product.getAmount() >= transaction.getAmount()) {
                trx.setProduct(product);
                trx.setStatus(1);
                trx.setCustomerName(transaction.getCustomerName());
                trx.setCreateBy(transaction.getCreateBy());
                trx.setCreateOn(new Date());
                trx.setAmount(transaction.getAmount());
                trx.setTransactionDate(new Date());

                product.setAmount(product.getAmount() - transaction.getAmount());
            }
            return transactionsRepository.save(trx);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void deleteTransaction(int id) {
        transactionsRepository.deleteById(id);
    }

}
