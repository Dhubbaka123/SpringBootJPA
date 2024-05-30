package com.twg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springboot.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
