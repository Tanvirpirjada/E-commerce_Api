package com.example.Ecomerce_api.Controller;

import com.example.Ecomerce_api.Model.User;
import com.example.Ecomerce_api.Service.Userservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCotroller {

    @Autowired
    Userservice userservice;

    @GetMapping("getuser")
    public User getuser(@RequestParam Integer user_id){
        return userservice.getuser(user_id);
    }

    @PostMapping("/saveuser")
    public ResponseEntity Saveuser(@RequestBody String requestuser){
        JSONObject userdetails=new JSONObject(requestuser);
       User newuser= setuser(userdetails);
       userservice.saveuser(newuser);
       return new ResponseEntity<>("User saved"+newuser, HttpStatus.CREATED);
    }

    public User setuser(JSONObject json){
        User user=new User();
        Integer user_id= json.getInt("user_id");
        user.setUser_id(user_id);

        user.setUser_name(json.getString("user_name"));
        user.setEmail(json.getString("email"));
        user.setPassword(json.getString("password"));
        user.setPhone_number(json.getString("phone_number"));

        return  user;
    }
}
