package com.twg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.entity.Customers;
import com.twg.springboot.repository.CustomersRepository;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersRepository customersRepository;

	
	@Override
	public Customers saveCustomer(Customers customer) {

		return customersRepository.save(customer);
		
	}


	@Override
	public Customers updateCustomer(Customers customer) {
		// TODO Auto-generated method stub
		return customersRepository.save(customer);
	}


	@Override
	public void deleteCustomer(Customers customer) {
		// TODO Auto-generated method stub
		customersRepository.delete(customer);
	}


	@Override
	public Customers findByCustomerId(int id) {
		// TODO Auto-generated method stub
		return customersRepository.findById(id).get();
	}


	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		return customersRepository.findAll();
	}

}
