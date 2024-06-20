package com.demo.arselCRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "amount", nullable = false)
    private Long amount;
    @Column(name = "waktu_update", nullable = false)
    private Date waktuUpdate;
}
