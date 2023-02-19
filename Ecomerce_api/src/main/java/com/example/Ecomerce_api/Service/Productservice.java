package com.example.Ecomerce_api.Service;

import com.example.Ecomerce_api.Dao.IProductrepository;
import com.example.Ecomerce_api.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {

    @Autowired
    IProductrepository productrepository;
    public void saveproduct(Product newproduct) {
           productrepository.save(newproduct);
    }

    public Product getallrpoduct(String category) {
        List<Product> products=productrepository.findAll();
        for(Product product: products){
            if(product.getCategory().equals(category)){
                return product;
            }
        }
        return null;
    }

    public void deleteproduct(Integer Id) {
        Product product=productrepository.findById(Id).get();

        productrepository.delete(product);
    }
}
