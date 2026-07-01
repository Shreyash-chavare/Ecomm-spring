package com.project.Ecomm.DTO;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long Id;

    private double totalAmount;

    private Date orderdate;

    private String username;
    private String email;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private List<OrderItemDTO> orderItemDTOList;

    public OrderDTO(Long id, double totalAmount, Date orderdate, String username, String email, List<OrderItemDTO> orderItemDTOList,String status) {
        Id = id;
        this.totalAmount = totalAmount;
        this.orderdate = orderdate;
        this.username = username;
        this.email = email;
        this.orderItemDTOList = orderItemDTOList;
        this.status=status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderItemDTO> getOrderItemDTOList() {
        return orderItemDTOList;
    }

    public void setOrderItemDTOList(List<OrderItemDTO> orderItemDTOList) {
        this.orderItemDTOList = orderItemDTOList;
    }
}
