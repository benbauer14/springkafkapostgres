package com.example.springkafkapostgres.bean;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="member1")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String first_name;
    private String last_name;
    private int member_id;
    private int phone_number;
    private int balance;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public int getMember_id(){
        return member_id;
    }

    public void setMember_id(int member_id){
        this.member_id = member_id;
    }

    public int getPhone_number(){
        return phone_number;
    }

    public void setPhone_number(int phone_number){
        this.phone_number = phone_number;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }



}
