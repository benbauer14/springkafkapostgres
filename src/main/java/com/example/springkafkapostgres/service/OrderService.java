package com.example.springkafkapostgres.service;

import com.example.springkafkapostgres.bean.Order;
import com.example.springkafkapostgres.repo.OrderCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderCRUD orderCRUD;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${order.topic.name}")
    private String topicName;

    ObjectMapper objectMapper = new ObjectMapper();

    public Order saveOrder(Order order){
        order.setStatus("CREATED");
        order = orderCRUD.save(order);
        try {
            String orderString = objectMapper.writeValueAsString(order);
            kafkaTemplate.send(topicName, orderString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return order;
    }

    public List<Order> getOrders(){
        return (List<Order>) orderCRUD.findAll();
    }
}
