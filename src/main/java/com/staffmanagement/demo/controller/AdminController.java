package com.staffmanagement.demo.controller;

import com.staffmanagement.demo.entity.Staff;
import com.staffmanagement.demo.repository.UserRepository;
import com.staffmanagement.demo.service.AdminService;
import com.staffmanagement.demo.service.AdminServiceImplementation;
import com.staffmanagement.demo.service.StaffService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/admin")
//@PreAuthorize("hasRole('USER')")
public class AdminController
{
    @Autowired
    private StaffService staffService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminServiceImplementation adminServiceImplementation;

    @GetMapping("/authenticate")
    public String loginGet() {
        return "hello welcome";
    }
    @PostMapping("/add-staff")
    public ResponseEntity<?> saveStaff(@RequestBody Staff newStaff) {
        if (userRepository.findByEmail(newStaff.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Staff already Exist");
        }
        return ResponseEntity.ok(adminServiceImplementation.createStaff(newStaff));
    }


    @GetMapping("/list-staff")
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    public Optional<Staff> getStaffId(@PathVariable int id){
        return  staffService.getStaffById(id);
    }

    @PutMapping("/update-staff/{id}")
    public Staff updateStaff(@PathVariable int id,@RequestBody Staff staff){
        return staffService.updateStaff(id,staff);
    }

    @DeleteMapping("/delete-staff/{id}")
    public void deleteStaff(@PathVariable int id ){
        staffService.deleteStaff(id);
    }
}


