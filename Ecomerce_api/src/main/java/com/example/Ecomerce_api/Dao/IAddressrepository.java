package com.example.Ecomerce_api.Dao;

import com.example.Ecomerce_api.Model.Address;
import org.hibernate.sql.exec.spi.JdbcCallParameterRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAddressrepository extends JpaRepository<Address,Integer> {
}
