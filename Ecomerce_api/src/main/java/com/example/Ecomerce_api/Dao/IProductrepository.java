package com.example.Ecomerce_api.Dao;

import com.example.Ecomerce_api.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductrepository  extends JpaRepository<Product,Integer> {
}
