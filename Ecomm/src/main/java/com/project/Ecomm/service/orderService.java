package com.project.Ecomm.service;

import com.project.Ecomm.DTO.OrderDTO;
import com.project.Ecomm.DTO.OrderItemDTO;
import com.project.Ecomm.model.Order;
import com.project.Ecomm.model.OrderItem;
import com.project.Ecomm.model.Product;
import com.project.Ecomm.model.User;
import com.project.Ecomm.repo.OrderRepo;
import com.project.Ecomm.repo.ProductRepo;
import com.project.Ecomm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class orderService {

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private ProductRepo productrepo;

    @Autowired
    private OrderRepo orderrepo;

    public OrderDTO placeorder(Long userid, Map<Long, Integer> productQuantities, double totalAmount) {

        User user=userrepo.findById(userid).orElseThrow(()-> new RuntimeException("User not found"));

        Order order=new Order();
        order.setUser(user);
        order.setOrderdate(new Date());
        order.setStatus("pending");
        order.setTotalAmount(totalAmount);

        List<OrderItem>orderitems= new ArrayList<>();
        List<OrderItemDTO>orderItemDTOS=new ArrayList<>();

        for(Map.Entry<Long,Integer>entry:productQuantities.entrySet()){
            Product product=productrepo.findById(entry.getKey())
                    .orElseThrow(()->new RuntimeException("product not found"));

            OrderItem orderitem=new OrderItem();
            orderitem.setOrder(order);
            orderitem.setProduct(product);
            orderitem.setQuantity(entry.getValue());
            orderitems.add(orderitem);

            orderItemDTOS.add(new OrderItemDTO(product.getName(),entry.getValue(),product.getPrice()));

        }
        order.setOrderitems(orderitems);
        orderrepo.save(order);

        return new OrderDTO(order.getId(),totalAmount,order.getOrderdate(),user.getName(),user.getEmail(),orderItemDTOS,order.getStatus());
    }

    public List<OrderDTO> getAllOrder() {
        List<Order>orders= orderrepo.findOrdersbyUsers();

        return orders.stream().map(order->convertToDTO(order)).collect(Collectors.toList());

    }

    public OrderDTO convertToDTO(Order orders){
        List<OrderItemDTO>orderitems=orders.getOrderitems().stream().
                map(item-> new OrderItemDTO(
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getProduct().getPrice()
                )).collect(Collectors.toList());

        return new OrderDTO(orders.getId(),orders.getTotalAmount(),orders.getOrderdate(),
                orders.getUser().getName(),orders.getUser().getEmail(),orderitems,orders.getStatus());
    }

    public List<OrderDTO> getOrderByuser(Long userid) {
        Optional<User>opuser=userrepo.findById(userid);
        if(opuser.isEmpty()){
            throw new RuntimeException("user not found!");
        }
        User user=opuser.get();
        List<Order>orders=orderrepo.findByUser(user);

        return orders.stream().map(order->convertToDTO(order)).collect(Collectors.toList());
    }
}
