package com.example.Ecomerce_api.Dao;

import com.example.Ecomerce_api.Model.Order;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderrepository extends JpaRepository<Order,Integer> {
}
