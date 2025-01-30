package com.School_management.service;

import com.School_management.entity.School;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    //    public School findById(int id) {
//        try {
//            return schoolRepository.findById(id).orElseThrow();
//        }catch (Exception e) {
//            throw new RuntimeException("School not found with ID: " + id);
//        }
//    }
    public School findById(int id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("School not found with ID :" + id));
    }

    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    public String deleteById(Integer id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return "School deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("School not found with ID: " + id);
        }
    }

    public School updateById(final School school, final Integer id) {
        final Optional<School> schoolOptional = this.schoolRepository.findById(id);
        if (schoolOptional.isEmpty()) {
            throw new UserNotFoundException("School not Found.");
        }
        final School schoolObject = schoolOptional.get();
        if (school.getName() != null) {
            schoolObject.setName(school.getName());
        }
        if (school.getAddress() != null) {
            schoolObject.setAddress(school.getAddress());
        }
        if (school.getContact() != 0) {
            schoolObject.setContact(school.getContact());
        }
        return schoolRepository.save(schoolObject);
    }
}
