package com.demo.arselCRUD.controller;

import com.demo.arselCRUD.entity.Transactions;
import com.demo.arselCRUD.pojo.TransactionsPojo;
import com.demo.arselCRUD.service.TransactionsService;
import com.demo.arselCRUD.utils.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionService;

    @GetMapping
    public ResponseEntity<MessageModel> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transactions getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transactions createTransaction(@RequestBody TransactionsPojo pojo) {
        return transactionService.saveTransaction(pojo);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransaction(id);
    }
}
