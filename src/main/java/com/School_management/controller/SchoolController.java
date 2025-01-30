package com.School_management.controller;

import com.School_management.entity.School;
import com.School_management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create")
    private School createSchool(@RequestBody School school) {
        return schoolService.saveSchool(school);
    }

    @GetMapping("/all")
    private List<School> getAllSchool() {
        return schoolService.getAllSchool();
    }

    @GetMapping("/{schoolId}")
    private School getSchoolById(@PathVariable int schoolId) {
        return schoolService.findById(schoolId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchoolById(@PathVariable Integer id) {
        return schoolService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public School updateById(@PathVariable("id") final Integer id, @RequestBody final School school) {
        return this.schoolService.updateById(school, id);
    }
}
