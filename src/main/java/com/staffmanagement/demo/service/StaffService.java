package com.staffmanagement.demo.service;

import com.staffmanagement.demo.entity.Staff;
import com.staffmanagement.demo.repository.StaffRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements StaffServiceInterface{

    @Autowired

    private StaffRepositary staffRepository;
    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> getStaffById(int id) {

        return staffRepository.findById(id);
    }

    public Staff getStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }
    @Override
    public List<Staff> getAllStaff() {

        return staffRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public Staff updateStaff(int id, Staff staff) {
    Staff staffToUpdate =staffRepository.findById(id).orElseThrow();
    staffToUpdate.setFullName(staff.getFullName());
    staffToUpdate.setEmail(staff.getEmail());
    staffToUpdate.setPhone(staff.getPhone());
    return staffRepository.save(staffToUpdate);


    }

    @Override
    public void deleteStaff(int id) {
        staffRepository.deleteById(id);

    }
}
