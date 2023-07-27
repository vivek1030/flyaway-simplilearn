package com.flyaway.booking.restapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.FlightBookings;
import com.flyaway.booking.service.FlightBookingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Flight Booking Management", description = "APIs for managing flight bookings.")
@RestController
@RequestMapping("/api")
public class FlightBookingsController {

    @Autowired
    private FlightBookingsService flightbookingService;

    @ApiOperation(value = "Get booking details", notes = "Retrieves flight booking details based on the provided booking ID.")
    @RequestMapping(method = RequestMethod.GET, value = "/flightbooking/{id}")
    public Map<String, Object> getBookingDetails(@PathVariable String id) {
        return flightbookingService.getBookingDetails(id);
    }

    @ApiOperation(value = "Add a new flight booking", notes = "Adds a new flight booking to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/flightbooking")
    public Map<String, Object> addFlightBookings(@RequestBody FlightBookings flightbooking) {
        return flightbookingService.addFlightBookings(flightbooking);
    }
}
