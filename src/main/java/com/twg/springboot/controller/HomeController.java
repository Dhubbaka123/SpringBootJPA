package com.twg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twg.springboot.entity.Customers;
import com.twg.springboot.service.CustomersService;

@RestController
public class HomeController {

	@Autowired
	private CustomersService customersService;

	@GetMapping("/customers")	//findAll
	public List<Customers> findAllCustomers(){
		List<Customers> listOfCustomers = customersService.findAll();
		
		return listOfCustomers;
	}
	
	@GetMapping("/customers/{customerid}")	//findById
	public Customers findCustomer(@PathVariable int customerid) {
		Customers customer = customersService.findByCustomerId(customerid);
		
		return customer;
		
	}
	
	@DeleteMapping("/customers/{customerid}")	//delete
	public void deleteCustomer(@PathVariable int customerid) {
		Customers customer1 = customersService.findByCustomerId(customerid);
		customersService.deleteCustomer(customer1);
	}
	
	
	@PostMapping("/customers")		//Insert or Save a customer record
	public Customers insertCustomer(@RequestBody Customers customer) {
		
		Customers insertedCustomer = customersService.saveCustomer(customer);
		
		return insertedCustomer;
	}
	
	@PutMapping("/customers")		//Update a Customer
	public Customers updateCustomers(@RequestBody Customers customer) {
	
		Customers updatedCustomer = customersService.updateCustomer(customer);
		return updatedCustomer;
	}
	
	
	@PatchMapping("/customers/{customerid}")
	public Customers modifyCustomersField(@PathVariable int customerid, @RequestBody Customers customer) {
		
		
		Customers modifiedCustomer = customersService.findByCustomerId(customerid);
		
		int customerId = customer.getCustomerid();
		String customerName = customer.getCustomername();
		String customerAddress = customer.getAddress();
		String customerDob = customer.getDateofbirth();
		
		if(customerId>0) {
			modifiedCustomer.setCustomerid(customerId);
		}
		if(customerName!=null && customerName.length()>0) {
			modifiedCustomer.setCustomername(customerName);			
		}
		if(customerAddress!=null && customerAddress.length()>0) {
			modifiedCustomer.setAddress(customerAddress);
		}
		if(customerDob!=null && customerDob.length()>0) {
			modifiedCustomer.setDateofbirth(customerDob);
		}
		
		return customersService.updateCustomer(modifiedCustomer);
	}
	
	
}
