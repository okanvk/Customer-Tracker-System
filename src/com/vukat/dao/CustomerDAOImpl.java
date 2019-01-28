package com.vukat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vukat.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	// need to inject the session factory(from xml)
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session current = sessionFactory.getCurrentSession();
		
		
		// sort by last name
		Query<Customer> theQuery = current.createQuery("from Customer order by last_name",Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
		
	}



	@Override
	public void saveCustomer(Customer customer) {
		
		Session current = sessionFactory.getCurrentSession();
		
		
		// Save if doesn't exists.in, db which appropriate id
		// Update if exists.in db, which appropriate id
		current.saveOrUpdate(customer);
		
		
	}



	@Override
	public Customer getCustomer(int id) {
		
		Session current = sessionFactory.getCurrentSession();
		
		Customer customer = current.get(Customer.class, id);
		
		return customer;
	}



	@Override
	public void deleteCustomer(int id) {
		Session current = sessionFactory.getCurrentSession();
		
		Query theQuery = current.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
		
	}
	
	

}
