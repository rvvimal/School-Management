package com.School_management.controller;

import com.School_management.entity.TutorCourse;
import com.School_management.service.TutorCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tutorCourse")
public class TutorCourseController {
    @Autowired
    private TutorCourseService tutorCourseService;

    @PostMapping("/create")
    private TutorCourse createtutorCourse(@RequestBody TutorCourse tutorCourse) {
        return tutorCourseService.saveTutorCourse(tutorCourse);
    }

    @GetMapping("/all")
    private List<TutorCourse> getAllTutorCourse() {
        return tutorCourseService.getAlltutorCourse();
    }

    @GetMapping("/{tutorCourseId}")
    private TutorCourse getTutorCourseById(@PathVariable int tutorCourseId) {
        return tutorCourseService.findById(tutorCourseId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTutorCourseById(@PathVariable Integer id) {
        return tutorCourseService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public TutorCourse updateById(@PathVariable("id") final Integer id, @RequestBody final TutorCourse tutorCourse) {
        return this.tutorCourseService.updateById(tutorCourse, id);

    }
}