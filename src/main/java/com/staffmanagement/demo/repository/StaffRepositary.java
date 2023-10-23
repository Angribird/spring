package com.staffmanagement.demo.repository;

import com.staffmanagement.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepositary  extends JpaRepository<Staff , Integer> {

    Staff findByEmail(String email);
}
