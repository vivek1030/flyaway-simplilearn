package com.flyaway.booking.restapi;

import java.util.Map;

import com.flyaway.booking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flyaway.booking.entity.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Admin Management", description = "APIs for managing admin.")
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "Validate Admin Credentials", notes = "Validates the admin's credentials.")
    @RequestMapping(method = RequestMethod.POST, value = "/validate/admin")
    public Map<String, Object> validateAdmin(@RequestBody Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        return adminService.validateAdmin(username, password);
    }

    @ApiOperation(value = "Update Admin Password", notes = "Updates the admin's password.")
    @RequestMapping(method = RequestMethod.PUT, value = "/admin")
    public Map<String, Object> updateAdmin(@RequestBody Admin adminpassword) {
        Admin admin = new Admin();
        admin.setId("1");
        admin.setUsername("admin");
        admin.setEmail("admin@gmail.com");
        admin.setName("Admin");
        admin.setPassword(adminpassword.getPassword());

        return adminService.updateAdmin(admin);
    }

}
