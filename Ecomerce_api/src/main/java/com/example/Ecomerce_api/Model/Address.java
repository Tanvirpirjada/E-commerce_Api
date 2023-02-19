package com.example.Ecomerce_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    private String address_name;
    private String landmark;
    private String add_phone_no;
    private String zipcode;
    private  String state;
    @JoinColumn
    @OneToOne
    private User userid;

}
