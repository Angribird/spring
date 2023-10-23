package com.staffmanagement.demo.service;

import com.staffmanagement.demo.entity.Role;
import com.staffmanagement.demo.entity.Staff;
import com.staffmanagement.demo.entity.User;
import com.staffmanagement.demo.repository.AdminRepository;
import com.staffmanagement.demo.entity.Admin;
import com.staffmanagement.demo.repository.StaffRepositary;
import com.staffmanagement.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation  implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffRepositary staffRepositary;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin addAdmin(Admin newAdmin){
        return adminRepository.save(newAdmin);

    }

    public Staff createStaff(Staff newStaff){
        var staff= User.builder()
                .fullname(newStaff.getFullName())
                .email(newStaff.getEmail())
                .password(passwordEncoder.encode(newStaff.getPhone()))
                .role(Role.USER)
                .build();
        userRepository.save(staff);

        return staffRepositary.save(newStaff);
    }
}
