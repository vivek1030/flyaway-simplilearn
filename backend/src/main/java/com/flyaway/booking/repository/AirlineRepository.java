package com.flyaway.booking.repository;

import com.flyaway.booking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, String>{
	

}
