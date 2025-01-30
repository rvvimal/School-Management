package com.School_management.controller;


import com.School_management.entity.Tutor;
import com.School_management.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tutor")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @PostMapping("/create")
    private Tutor createtutor(@RequestBody Tutor tutor) {
        return tutorService.saveTutor(tutor);
    }

    @GetMapping("/all")
    private List<Tutor> getAllTutor() {
        return tutorService.getAlltutor();
    }

    @GetMapping("/{tutorId}")
    private Tutor getTutorById(@PathVariable int tutorId) {
        return tutorService.findById(tutorId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTutorById(@PathVariable Integer id) {
        return tutorService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Tutor updateById(@PathVariable("id") final Integer id, @RequestBody final Tutor tutor) {
        return this.tutorService.updateById(tutor, id);

    }
}
