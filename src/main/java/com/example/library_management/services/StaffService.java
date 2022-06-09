package com.example.library_management.services;

import com.example.library_management.models.StaffModel;
import com.example.library_management.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public StaffModel createStaff(StaffModel staff) {
        Optional<StaffModel> optionalStaffModel = staffRepository.findById(staff.getId());
        if(optionalStaffModel.isPresent()) {
            throw new EntityNotFoundException("Staff is already exist");
        }
        else {
            return staffRepository.save(staff);
        }
    }

    public StaffModel updateStaff(StaffModel staff, String id) {
        Optional<StaffModel> optionalStaffModel = staffRepository.findById(id);
        if(optionalStaffModel.isEmpty()) {
            throw new EntityNotFoundException("Staff is not exist");
        }
        else {
            staff.setId(id);
            if(staff.getName() == null || staff.getName().isEmpty()) {
                staff.setName(optionalStaffModel.get().getName());
            }
            if(staff.getPhoneNumber() == null || staff.getPhoneNumber().isEmpty()) {
                staff.setPhoneNumber(optionalStaffModel.get().getPhoneNumber());
            }

            return staffRepository.save(staff);
        }
    }

    public void deleteStaff(String id) {
        Optional<StaffModel> optionalStaffModel = staffRepository.findById(id);
        if(optionalStaffModel.isEmpty()) {
            throw new EntityNotFoundException("Staff is not exist");
        }
        else {
            staffRepository.deleteById(id);
        }
    }

    public List<StaffModel> getAllStaffs() {
        return staffRepository.findAll();
    }
}
