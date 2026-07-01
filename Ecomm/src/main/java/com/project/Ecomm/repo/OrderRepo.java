package com.project.Ecomm.repo;

import com.project.Ecomm.model.Order;
import com.project.Ecomm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query("select o from Order o JOIN FETCH o.user")
    List<Order> findOrdersbyUsers();

    List<Order>findByUser(User user);


}
