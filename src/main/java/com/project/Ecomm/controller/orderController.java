package com.project.Ecomm.controller;


import com.project.Ecomm.DTO.OrderDTO;
import com.project.Ecomm.model.OrderRequest;
import com.project.Ecomm.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    private orderService orderservice;

    @PostMapping("/placeorder/{userid}")
    public OrderDTO placeorder(@PathVariable Long userid, @RequestBody OrderRequest orderrequest){
         return orderservice.placeorder(userid,orderrequest.getProductQuantities(),orderrequest.getTotalAmount());
    }

    @GetMapping("/allOrder")
    public List<OrderDTO>getorders(){
        return orderservice.getAllOrder();
    }

    @GetMapping("/getOrder/{userid}")
    public List<OrderDTO> getUserOrder(@PathVariable Long userid){
        return orderservice.getOrderByuser(userid);
    }
}
