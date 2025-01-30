package com.School_management.controller;


import com.School_management.entity.TutorSalary;
import com.School_management.service.TutorSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tutorSalary")
public class TutorSalaryController {
    @Autowired
    private TutorSalaryService tutorSalaryService;

    @PostMapping("/create")
    private TutorSalary createtutorSalary(@RequestBody TutorSalary tutorSalary) {
        return tutorSalaryService.saveTutorSalary(tutorSalary);
    }

    @GetMapping("/all")
    private List<TutorSalary> getAllTutorSalary() {
        return tutorSalaryService.getAlltutorSalary();
    }

    @GetMapping("/{tutorSalaryId}")
    private TutorSalary getTutorSalaryById(@PathVariable int tutorSalaryId) {
        return tutorSalaryService.findById(tutorSalaryId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTutorSalaryById(@PathVariable Integer id) {
        return tutorSalaryService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public TutorSalary updateById(@PathVariable("id") final Integer id, @RequestBody final TutorSalary tutorSalary) {
        return this.tutorSalaryService.updateById(tutorSalary, id);

    }
}
