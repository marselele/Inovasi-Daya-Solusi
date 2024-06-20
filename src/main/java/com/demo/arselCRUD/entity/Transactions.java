package com.demo.arselCRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;
    @Column(name = "amount", nullable = false)
    private Long amount;
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    @Column(name = "status", nullable = false)
    private int status;
    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;
    @Column(name = "create_by", nullable = false)
    private String createBy;
    @Column(name = "create_on", nullable = false)
    private Date createOn;
}
