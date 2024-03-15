package com.example.springkafkapostgres.controller;

import com.example.springkafkapostgres.bean.Order;
import com.example.springkafkapostgres.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }
    @PostMapping("/create")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
