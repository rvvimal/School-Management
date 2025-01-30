package com.School_management.service;

import com.School_management.entity.Student;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Student not found with ID :" + id));
    }

    //    public Student findById(int id) {
//        try {
//            return studentRepository.findById(id).orElseThrow();
//        } catch (Exception e) {
//            throw new RuntimeException("Student not found with ID: " + id, e);
//        }
//    }
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String deleteById(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("Student not found with ID: " + id);
        }
    }

    public Student updateById(final Student student, final Integer id) {
        final Optional<Student> studentOptional = this.studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            throw new UserNotFoundException("Student not Found.");
        }
        final Student studentObject = studentOptional.get();
        if (student.getFirstName() != null) {
            studentObject.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            studentObject.setLastName(student.getLastName());
        }
        if (student.getEmailId() != null) {
            studentObject.setEmailId(student.getEmailId());
        }
        if (student.getEnrollementDate() != null) {
            studentObject.setEnrollementDate(student.getEnrollementDate());
        }
        if (student.getContact() != 0) {
            studentObject.setContact(student.getContact());
        }
        return studentRepository.save(studentObject);
    }
}
