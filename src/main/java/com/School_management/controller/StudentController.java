package com.School_management.controller;

import com.School_management.entity.Student;
import com.School_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    private Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/all")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();

    }

    @GetMapping("/{studentId}")
    private Student getStudentById(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id) {
        return studentService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateById(@PathVariable("id") final Integer id, @RequestBody final Student student) {
        return this.studentService.updateById(student, id);
    }
}
