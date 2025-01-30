package com.School_management.controller;

import com.School_management.entity.Course;
import com.School_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    private Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/all")
    private List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{courseId}")
    private Course getCourseById(@PathVariable int courseId) {
        return courseService.findById(courseId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable Integer id) {
        return courseService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Course updateById(@PathVariable("id") final Integer id, @RequestBody final Course course) {
        return this.courseService.updateById(course, id);
    }
}
