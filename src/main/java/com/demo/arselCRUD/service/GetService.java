package com.demo.arselCRUD.service;

import com.demo.arselCRUD.entity.Status;
import com.demo.arselCRUD.entity.Transactions;
import com.demo.arselCRUD.repository.ProductsRepository;
import com.demo.arselCRUD.repository.StatusRepository;
import com.demo.arselCRUD.repository.TransactionsRepository;
import com.demo.arselCRUD.utils.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetService {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    StatusRepository statusRepository;


    public ResponseEntity<MessageModel> getAll() {
        MessageModel msg = new MessageModel();
        try {
            List<Transactions> datas = transactionsRepository.findAll();
            List<Status> statuses = statusRepository.findAll();
            msg.setStatus(statuses.isEmpty() ? new ArrayList<>(): statuses);
            msg.setData(datas.isEmpty() ? new ArrayList<>() : datas);
            return new ResponseEntity<>(msg, datas.isEmpty() ? HttpStatus.NOT_FOUND :HttpStatus.OK);
        } catch (Exception e) {
            msg.setStatus(null);
            msg.setData(null);
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
