package com.vukat.service;

import java.util.List;

import com.vukat.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
