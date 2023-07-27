package com.flyaway.booking.restapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.Customer;
import com.flyaway.booking.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Customer Management", description = "APIs for managing customer information.")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Get customer details", notes = "Retrieves customer details based on the provided customer ID.")
    @RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
    public Optional<Customer> getCustomerDetails(@PathVariable String id) {
        return customerService.getCustomerDetails(id);
    }

    @ApiOperation(value = "Add a new customer", notes = "Adds a new customer to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }
}
