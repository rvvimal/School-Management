package com.School_management.service;


import com.School_management.entity.TutorSalary;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.TutorSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorSalaryService {
    @Autowired
    private TutorSalaryRepository tutorSalaryRepository;

    public TutorSalary saveTutorSalary(TutorSalary tutorSalary) {
        return tutorSalaryRepository.save(tutorSalary);
    }

    public TutorSalary findById(int id) {
        return tutorSalaryRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("TutorSalary not found with ID :" + id));
    }

    //    public TutorSalary findById(int id) {
//        try {
//            return tutorSalaryRepository.findById(id).orElseThrow();
//        } catch (Exception e) {
//            throw new RuntimeException("TutorSalary not found with ID: " + id, e);
//        }
//    }
    public List<TutorSalary> getAlltutorSalary() {
        return tutorSalaryRepository.findAll();
    }

    public String deleteById(int id) {
        if (tutorSalaryRepository.existsById(id)) {
            tutorSalaryRepository.deleteById(id);
            return "TutorSalary deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("TutorSalary not found with ID: " + id);
        }
    }

    public TutorSalary updateById(final TutorSalary tutorSalary, final Integer id) {
        final Optional<TutorSalary> tutorSalaryOptional = this.tutorSalaryRepository.findById(id);
        if (tutorSalaryOptional.isEmpty()) {
            throw new UserNotFoundException("TutorSalary not Found.");
        }
        final TutorSalary tutorSalaryObject = tutorSalaryOptional.get();
        if (tutorSalary.getPaymentMonth() != null) {
            tutorSalaryObject.setPaymentMonth(tutorSalary.getPaymentMonth());
        }

        if (tutorSalary.getSalaryAmount() != 0) {
            tutorSalaryObject.setSalaryAmount(tutorSalary.getSalaryAmount());
        }
        if (tutorSalary.getSalaryPaid() != null) {
            tutorSalaryObject.setSalaryPaid(tutorSalary.getSalaryPaid());
        }
        return tutorSalaryRepository.save(tutorSalaryObject);
    }
}
