package com.example.Ecomerce_api.Controller;

import com.example.Ecomerce_api.Dao.IUserrepository;
import com.example.Ecomerce_api.Model.Address;
import com.example.Ecomerce_api.Model.User;
import com.example.Ecomerce_api.Service.Addressservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addresscontroller {

    @Autowired
    Addressservice addressservice;
@Autowired
    IUserrepository userrepository;

@PostMapping("saveadress")
    public ResponseEntity saveaddress(@RequestBody String requestaddress){
        JSONObject addressdetails=new JSONObject(requestaddress);
        Address newaddress=setaddress(addressdetails);
        addressservice.saveaddress(newaddress);
        return  new ResponseEntity<>("save adress"+newaddress,HttpStatus.CREATED);
    }

    public Address setaddress(JSONObject json){
        Address address=new Address();
        address.setAddress_id(json.getInt("address_id"));
        address.setAddress_name(json.getString("address_name"));
        address.setLandmark(json.getString("landmark"));
        address.setAdd_phone_no(json.getString(".phone_number"));

        address.setZipcode(json.getString("zipcode"));

        address.setState(json.getString("state"));

        Integer user_id= json.getInt("user_id");
        User user=userrepository.findById(user_id).get();
        address.setUserid(user);

        return address;
    }
}
