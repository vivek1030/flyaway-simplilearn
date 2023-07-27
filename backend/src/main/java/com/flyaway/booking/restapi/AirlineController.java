package com.flyaway.booking.restapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.Airline;
import com.flyaway.booking.service.AirlineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Airline Management", description = "APIs for managing airlines.")
@RestController
@RequestMapping("/api")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @ApiOperation(value = "Get all airlines", notes = "Retrieves a map containing all airlines' information.")
    @RequestMapping(method = RequestMethod.GET, value = "/airlines")
    public Map<String, Object> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @ApiOperation(value = "Add a new airline", notes = "Adds a new airline to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/airlines")
    public Map<String, Object> addAirline(@RequestBody Airline airline) {
        return airlineService.addAirline(airline);
    }

    @ApiOperation(value = "Update an airline", notes = "Updates an existing airline.")
    @RequestMapping(method = RequestMethod.PUT, value = "/airline/{id}")
    public Map<String, Object> updateAirline(@PathVariable String id, @RequestBody Airline airline) {
        return airlineService.updateAirline(id, airline);
    }

    @ApiOperation(value = "Delete an airline", notes = "Deletes an airline from the system.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/airline/{id}")
    public Map<String, Object> deleteAirline(@PathVariable String id) {
        return airlineService.deleteAirline(id);
    }
}
