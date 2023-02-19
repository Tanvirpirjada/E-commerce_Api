package com.example.Ecomerce_api.Dao;

import com.example.Ecomerce_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserrepository extends JpaRepository<User,Integer> {
}
