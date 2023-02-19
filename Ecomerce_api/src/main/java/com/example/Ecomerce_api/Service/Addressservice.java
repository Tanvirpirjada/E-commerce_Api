package com.example.Ecomerce_api.Service;

import com.example.Ecomerce_api.Dao.IAddressrepository;
import com.example.Ecomerce_api.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Addressservice {

    @Autowired
    IAddressrepository addressrepository;
    public void saveaddress(Address newaddress) {
        addressrepository.save(newaddress);
    }
}
