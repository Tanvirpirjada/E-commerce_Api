package com.example.Ecomerce_api.Service;

import com.example.Ecomerce_api.Dao.IOrderrepository;
import com.example.Ecomerce_api.Model.Order;
import org.aspectj.weaver.ast.Or;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Orderservice {

    @Autowired
    IOrderrepository orderrepository;
    public void saveorder(Order newrorder) {
        orderrepository.save(newrorder);
    }

    public JSONArray getorder(Integer orderId){
        JSONArray jsonArray=new JSONArray();
        List<Order> neworder=new ArrayList<>();
        neworder.add(orderrepository.findById(orderId).get());

        for(Order orders : neworder){
            JSONObject json=new JSONObject();
            json.put("order_id",orders.getOrder_id());
            json.put("user_id",orders.getUserid().getUser_id());
            json.put("product_id",orders.getProductId().getProduct_id());
            json.put("address_id",orders.getAddressId().getAddress_id());
            jsonArray.put(json);
        }
        return jsonArray;
    }
}
