package com.flyaway.booking.restapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.Flights;
import com.flyaway.booking.service.FlightsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Flight Management", description = "APIs for managing flight information.")
@RestController
@RequestMapping("/api")
public class FlightsController {

    @Autowired
    private FlightsService flightsService;

    @ApiOperation(value = "Get all flights", notes = "Retrieves a map containing all flight details.")
    @RequestMapping(method = RequestMethod.GET, value = "/flights")
    public Map<String, Object> getAllFlights() {
        return flightsService.getAllFlights();
    }

    @ApiOperation(value = "Add a new flight", notes = "Adds a new flight to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/flights")
    public Map<String, Object> addFlight(@RequestBody Flights flights) {
        return flightsService.addFlight(flights);
    }

    @ApiOperation(value = "Get complete flight details", notes = "Retrieves a map containing complete flight details.")
    @RequestMapping(method = RequestMethod.GET, value = "/completeflightdetails")
    public Map<String, Object> completeFlightDetails() {
        return flightsService.completeFlightDetails();
    }

    @ApiOperation(value = "Search flights", notes = "Searches for flights based on source ID, destination ID, date, and the number of passengers.")
    @RequestMapping(method = RequestMethod.GET, value = "/searchflights/{sourceid}/{desid}/{date}/{noofpass}")
    public Map<String, Object> searchFlightDetails(@PathVariable String sourceid, @PathVariable String desid, @PathVariable String date, @PathVariable String noofpass) {
        return flightsService.searchFlightDetails(sourceid, desid, date, noofpass);
    }

    @ApiOperation(value = "Update a flight", notes = "Updates an existing flight.")
    @RequestMapping(method = RequestMethod.PUT, value = "/flight/{id}")
    public Map<String, Object> updateFlight(@PathVariable String id, @RequestBody Flights flights) {
        return flightsService.updateFlight(id, flights);
    }

    @ApiOperation(value = "Delete a flight", notes = "Deletes a flight from the system.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/flight/{id}")
    public Map<String, Object> deleteFlight(@PathVariable Long id) {
        return flightsService.deleteFlight(id);
    }
}
