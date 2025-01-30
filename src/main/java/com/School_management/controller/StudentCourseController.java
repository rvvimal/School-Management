package com.School_management.controller;

import com.School_management.entity.StudentCourse;
import com.School_management.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/create")
    private StudentCourse createStudentCourse(@RequestBody StudentCourse studentCourse) {
        return studentCourseService.saveStudentCourse(studentCourse);
    }

    @GetMapping("/all")
    private List<StudentCourse> getAllStudentCourse() {
        return studentCourseService.getAllStudentCourse();
    }

    @GetMapping("/{studentCourseId}")
    private StudentCourse getStudentCourseById(@PathVariable int studentCourseId) {
        return studentCourseService.findById(studentCourseId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentCourseById(@PathVariable Integer id) {
        return studentCourseService.deleteById(id);
    }
}
