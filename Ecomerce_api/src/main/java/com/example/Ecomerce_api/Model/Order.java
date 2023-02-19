package com.example.Ecomerce_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Integer order_id;
    @JoinColumn
    @ManyToOne
    private User userid;
    @JoinColumn
    @OneToOne
    private Product productId;


    @JoinColumn
    @ManyToOne
    private Address addressId;
}
