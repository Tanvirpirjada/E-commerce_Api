package com.example.Ecomerce_api.Service;

import com.example.Ecomerce_api.Dao.IUserrepository;
import com.example.Ecomerce_api.Model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {


    @Autowired
    IUserrepository userrepository;
    public void saveuser(User userdetails) {
        userrepository.save(userdetails);
    }

    public User getuser(Integer userId) {
        return userrepository.findById(userId).get();
    }
}
