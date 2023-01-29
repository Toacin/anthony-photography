package com.antphoto.controller;

import com.antphoto.model.Order;
import com.antphoto.repository.OrderRepository;
import com.antphoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository repository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/orders")
    public List<Order> getAllOrders(){
        List<Order> orders = repository.findAll();
        return orders;
    }

    @GetMapping("/api/orders/{id}")
    public Order getOneOrder(@PathVariable Integer id){
        Order order = repository.getReferenceById(id);
        return order;
    }

    @PostMapping("/api/orders/{userId}")
    public Order createOneOrder(@PathVariable Integer userId, @RequestBody Integer[] requestb){
        Order order = new Order();
        order.setUserId(userId);
        Order newOrder = repository.save(order);
        for(int i=0; i< requestb.length; i++){
            userRepository.addPhotoToUser(userId, requestb[i]);
            repository.addIdsToOrderPhoto(requestb[i], newOrder.getId());
        }
        return newOrder;
    }

    @GetMapping("/api/orders/user/{userId}")
    public List<Order> getOrderByUserId(@PathVariable Integer userId){
        List<Order> orders = repository.findAllByUserId(userId);
        return orders;
    }
}
