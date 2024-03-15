package com.example.springkafkapostgres.listener;

import com.example.springkafkapostgres.bean.Order;
import com.example.springkafkapostgres.bean.User;
import com.example.springkafkapostgres.repo.MemberCRUD;
import com.example.springkafkapostgres.repo.OrderCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationListener {
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    OrderCRUD orderCRUD;

    @Autowired
    MemberCRUD memberCRUD;

    @KafkaListener(topics = "order-topic", groupId = "group_id")
    public void processOrder(String order) {
        System.out.println("Order Received: " + order);
        try {
            Order orderValue = objectMapper.readValue(order, Order.class);
            System.out.println("Order: " + orderValue);
            User member = memberCRUD.findById(orderValue.getMemberId()).get();
            System.out.println("Member: " + member);
            if(member.getBalance() >= orderValue.getOrderAmount()){
                orderValue.setStatus("SUCCESS");
                member.setBalance(member.getBalance() - orderValue.getOrderAmount());
                memberCRUD.save(member);
            }
            orderCRUD.save(orderValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
