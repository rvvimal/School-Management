package com.School_management.service;

import com.School_management.entity.Course;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course findById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Course not found with ID :" + id));
    }

    //    public Course findById(int id) {
//        try {
//            return courseRepository.findById(id).orElseThrow();
//        }catch (Exception e) {
//            throw new RuntimeException("Course not found with ID: " + id);
//        }
//    }
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public String deleteById(Integer id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return "Course deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("Course not found with ID: " + id);
        }
    }

    public Course updateById(final Course course, final Integer id) {
        final Optional<Course> courseOptional = this.courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            throw new UserNotFoundException("Course not Found.");
        }
        final Course courseObject = courseOptional.get();
        if (course.getName() != null) {
            courseObject.setName(course.getName());
        }

        return courseRepository.save(courseObject);
    }
}

