package com.demo.arselCRUD.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionsResponsePojo {

    Integer id;
    Integer productID;
    String productName;
    Long amount;
    String customerName;
    Date transactionDate;
    String createdBy;
    Date createdOn;
}
