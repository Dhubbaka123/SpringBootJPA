package com.twg.springboot.service;

import java.util.List;

import com.twg.springboot.entity.Customers;

public interface CustomersService {

	public Customers saveCustomer(Customers customer);
	public Customers updateCustomer(Customers customer);
	public void deleteCustomer(Customers customer);
	public Customers findByCustomerId(int id);
	public List<Customers> findAll();
}
