package com.staffmanagement.demo.service;

import com.staffmanagement.demo.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffServiceInterface {
    public Staff saveStaff(Staff staff);
    public Optional<Staff> getStaffById(int id);
    List<Staff> getAllStaff();
    Staff updateStaff(int id,Staff staff);
    void deleteStaff(int id);

}
