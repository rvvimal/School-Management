package com.School_management.service;

import com.School_management.entity.StudentCourse;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public StudentCourse findById(int id) {
        return studentCourseRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("StudentCourse not found with ID :" + id));
    }

    //        public StudentCourse findById(int id) {
//            try {
//                return studentCourseRepository.findById(id).orElseThrow();
//            } catch (Exception e) {
//                throw new RuntimeException("StudentCourse not found with ID: " + id, e);
//            }
//        }
    public List<StudentCourse> getAllStudentCourse() {
        return studentCourseRepository.findAll();
    }

    public String deleteById(int id) {
        if (studentCourseRepository.existsById(id)) {
            studentCourseRepository.deleteById(id);
            return "StudentCourse deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("StudentCourse not found with ID: " + id);
        }
    }
}

