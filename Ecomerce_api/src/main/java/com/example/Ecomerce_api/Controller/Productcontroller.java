package com.example.Ecomerce_api.Controller;

import com.example.Ecomerce_api.Model.Product;
import com.example.Ecomerce_api.Service.Productservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Productcontroller {

    @Autowired
    Productservice productservice;

    @GetMapping("getallproduct")
    public Product getallproduct(@RequestParam String category){
      return  productservice.getallrpoduct(category);
    }

    @DeleteMapping("deleteproduct/id/{id}")
    public ResponseEntity deleteproduct(@PathVariable Integer id){
        productservice.deleteproduct(id);
        return new ResponseEntity<>("product deleted",HttpStatus.OK);

    }

    @PostMapping("/saveproduct")
    public ResponseEntity saveproduct(@RequestBody  String requestproduct){
        JSONObject productdetails=new JSONObject(requestproduct);
        Product newproduct=setproduct(productdetails);
        productservice.saveproduct(newproduct);

        return new ResponseEntity<>("Product save"+newproduct, HttpStatus.CREATED);
    }

    public Product setproduct(JSONObject json){
        Product product=new Product();

        product.setProduct_id(json.getInt("product_id"));
        product.setProduct_name(json.getString("product_name"));
        product.setPrice(json.getInt("price"));
        product.setDescription(json.getString("description"));
        product.setCategory(json.getString("category"));
        product.setBrand(json.getString("brand"));

        return product;
    }
}
