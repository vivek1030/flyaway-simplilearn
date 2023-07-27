package com.flyaway.booking.repository;

import com.flyaway.booking.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, String>{


}
