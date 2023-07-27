package com.flyaway.booking.restapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.Payments;
import com.flyaway.booking.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Payment Management", description = "APIs for managing payment information.")
@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "Get all payment details", notes = "Retrieves a map containing all payment details.")
    @RequestMapping(method = RequestMethod.GET, value = "/getPaymentDetails")
    public Map<String, Object> getAllPaymentDetails() {
        return paymentService.getAllPaymentDetails();
    }

    @ApiOperation(value = "Get payment details by ID", notes = "Retrieves payment details based on the provided payment ID.")
    @RequestMapping(method = RequestMethod.GET, value = "/getPaymentDetails/{id}")
    public Map<String, Object> getPaymentDetails(@PathVariable String id) {
        return paymentService.getPaymentDetails(id);
    }

    @ApiOperation(value = "Add payment details", notes = "Adds new payment details to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/savepaymentdetails")
    public Map<String, Object> addPaymentDetails(@RequestBody Payments payments) {
        return paymentService.addPaymentDetails(payments);
    }

    @ApiOperation(value = "Delete payment details by ID", notes = "Deletes payment details based on the provided payment ID.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/paymentdetails/{id}")
    public Map<String, Object> deletePaymentDetails(@PathVariable String id) {
        return paymentService.deletePaymentDetails(id);
    }
}
