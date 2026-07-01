package com.project.Ecomm.controller;

import com.project.Ecomm.model.Product;
import com.project.Ecomm.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class productController {

    @Autowired
    private productService productservice;

    @GetMapping("/all")
    public List<Product> getAllproduct(){
        return productservice.findproducts();
    }

    @GetMapping("/get/{prod_id}")
    public Product getproduct(@PathVariable Long prod_id){
        return productservice.findproductByid(prod_id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody  Product product){
        return productservice.addproduct(product);
    }

    @PostMapping("/delete/{prod_id}")
    public void deleteProduct(@RequestBody Long prod_id){
        boolean prod= productservice.deleteproduct(prod_id);
        if(prod){
            System.out.println("product deleted successfully");
        }
        else{
            System.out.println("No such product exist!");
        }
    }

}
