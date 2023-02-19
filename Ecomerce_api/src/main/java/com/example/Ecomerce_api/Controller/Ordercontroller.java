package com.example.Ecomerce_api.Controller;

import com.example.Ecomerce_api.Dao.IAddressrepository;
import com.example.Ecomerce_api.Dao.IProductrepository;
import com.example.Ecomerce_api.Dao.IUserrepository;
import com.example.Ecomerce_api.Model.Address;
import com.example.Ecomerce_api.Model.Order;
import com.example.Ecomerce_api.Model.Product;
import com.example.Ecomerce_api.Model.User;
import com.example.Ecomerce_api.Service.Orderservice;
import org.aspectj.weaver.ast.Or;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Ordercontroller {

    @Autowired
    IUserrepository userrepository;

    @Autowired
    IProductrepository productrepository;

    @Autowired
    IAddressrepository addressrepository;
    @Autowired
    Orderservice orderservice;

    @PostMapping("saveorder")
    public ResponseEntity saveorder(@RequestBody String requestorder){
        JSONObject orderdetails=new JSONObject(requestorder);
        Order newrorder=setorder(orderdetails);
        orderservice.saveorder(newrorder);
        return new ResponseEntity<>("order placed"+newrorder, HttpStatus.CREATED);
    }

    @GetMapping("getorder")
    public ResponseEntity getorder(@RequestParam Integer order_id){
        JSONArray order=orderservice.getorder(order_id);
        return new ResponseEntity<>(order.toString(),HttpStatus.OK);
    }

    public Order setorder(JSONObject json){
        Order order=new Order();
        order.setOrder_id(json.getInt("order_id"));

        Integer user_id=json.getInt("user_id");
        User user=userrepository.findById(user_id).get();
        order.setUserid(user);

        Integer product_id=json.getInt("product_id");
        Product product =productrepository.findById(product_id).get();
        order.setProductId(product);

        Integer address_id=json.getInt("address_id");
        Address address =addressrepository.findById(address_id).get();
        order.setAddressId(address);

        return order;
    }
}
