package com.project.Ecomm.service;


import com.project.Ecomm.model.Product;
import com.project.Ecomm.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class productService {
    @Autowired
    private ProductRepo productrepo;


    public List<Product> findproducts() {

        return productrepo.findAll();
    }


    public Product findproductByid(Long prodId) {

        return productrepo.findById(prodId).orElseThrow(()->new RuntimeException("product not found"));
    }


    public Product addproduct(Product product) {

        return productrepo.save(product);
    }

    public boolean deleteproduct(Long prodId) {
        Product prod=productrepo.findById(prodId).orElseThrow(()->new RuntimeException("product not found"));
        if(prod!=null){
            productrepo.deleteById(prodId);
            return true;
        }
        return false;
    }
}
