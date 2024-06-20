package com.demo.arselCRUD.repository;

import com.demo.arselCRUD.entity.Transactions;
import com.demo.arselCRUD.pojo.TransactionsResponsePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
//Integer id;
//    String productID;
//    String productName;
//    Long amount;
//    String customerName;
//    Integer status;
//    Date transactionDate;
//    String createdBy;
//    Date createOn;
    @Query(value = "SELECT id, product_id as productID, amount, customer_name as customerName, status, transaction_date as transactionDate, create_by as createdBy, create_on as createdOn FROM transactions", nativeQuery = true)
    List<TransactionsResponsePojo> getTrx();
}
