package com.staffmanagement.demo.controller;

import com.staffmanagement.demo.entity.Staff;
import com.staffmanagement.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;


//    @GetMapping
//    public List<Staff> getAllStaff(){
//        return staffService.getAllStaff();
//    }
    @GetMapping("/email")
    public Staff getStaffId(Principal principal){
        return  staffService.getStaffByEmail(principal.getName());
    }
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable int id,@RequestBody Staff staff){
        return staffService.updateStaff(id,staff);
    }
    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable int id ){
        staffService.deleteStaff(id);
    }

}
