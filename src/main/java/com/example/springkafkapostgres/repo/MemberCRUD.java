package com.example.springkafkapostgres.repo;

import com.example.springkafkapostgres.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCRUD extends CrudRepository<User, Integer> {

}
