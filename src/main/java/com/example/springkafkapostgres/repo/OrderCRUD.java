package com.example.springkafkapostgres.repo;

import com.example.springkafkapostgres.bean.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCRUD extends CrudRepository<Order, Integer> {

}
