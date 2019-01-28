package com.vukat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vukat.dao.CustomerDAO;
import com.vukat.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customer DAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	
	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
	
	
	//Why services ?
	
	// Intermediate layer for business logic
	// (Temel iş mantığını uygulamak için)
	
	// Integrate data from multiple resources
	// (Farklı kaynaklardan gelen verileri toplamak için)

}
