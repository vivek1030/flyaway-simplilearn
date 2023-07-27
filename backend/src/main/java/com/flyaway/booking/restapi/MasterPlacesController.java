package com.flyaway.booking.restapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.MasterPlaces;
import com.flyaway.booking.service.MasterPlacesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Master Places Management", description = "APIs for managing master places information.")
@RestController
@RequestMapping("/api")
public class MasterPlacesController {

    @Autowired
    private MasterPlacesService masterPlacesService;

    @ApiOperation(value = "Get all master places", notes = "Retrieves a map containing all master places' information.")
    @RequestMapping(method = RequestMethod.GET, value = "/masterplaces")
    public Map<String, Object> getAllMasterPlaces() {
        return masterPlacesService.getAllMasterPlaces();
    }

    @ApiOperation(value = "Add a new master place", notes = "Adds a new master place to the system.")
    @RequestMapping(method = RequestMethod.POST, value = "/masterplaces")
    public Map<String, Object> addMasterPlaces(@RequestBody MasterPlaces masterplaces) {
        return masterPlacesService.addMasterPlaces(masterplaces);
    }

    @ApiOperation(value = "Delete a master place", notes = "Deletes a master place from the system.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/masterplaces/{id}")
    public Map<String, Object> deleteMasterPlaces(@PathVariable String id) {
        return masterPlacesService.deleteMasterPlaces(id);
    }
}
