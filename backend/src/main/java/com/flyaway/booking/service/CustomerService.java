package com.flyaway.booking.service;

import java.util.Optional;

import com.flyaway.booking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyaway.booking.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepo;

	
	public Optional<Customer> getCustomerDetails(String id) {
		return customerRepo.findById(id);
	}

	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
}
