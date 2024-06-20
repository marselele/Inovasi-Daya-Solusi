package com.demo.arselCRUD.pojo;

import lombok.Data;

@Data
public class TransactionsPojo {
    private Integer productID;
    private Long amount;
    private String customerName;
    private int status;
    private String createBy;

}
