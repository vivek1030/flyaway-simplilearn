package com.flyaway.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flyaway.booking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	

}
