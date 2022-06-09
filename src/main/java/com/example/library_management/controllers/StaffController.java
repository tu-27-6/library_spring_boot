package com.example.library_management.controllers;

import com.example.library_management.models.LibraryCardModel;
import com.example.library_management.models.StaffModel;
import com.example.library_management.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/get_all_staffs")
    public ResponseEntity<?> getAllStaffs() {
        try {
            List<StaffModel> data = staffService.getAllStaffs();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_staff")
    public ResponseEntity<?> createStaff(@RequestBody StaffModel staff) {
        try {
            StaffModel data = staffService.createStaff(staff);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_staff")
    public ResponseEntity<?> deleteStaff(@RequestParam String id) {
        try {
            staffService.deleteStaff(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_staff")
    public ResponseEntity<?> updateStaff(@RequestBody StaffModel staff, @RequestParam String id) {
        try {
            StaffModel data = staffService.updateStaff(staff, id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
