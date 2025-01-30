package com.School_management.service;


import com.School_management.entity.TutorCourse;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.TutorCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorCourseService {
    @Autowired
    private TutorCourseRepository tutorCourseRepository;

    public TutorCourse saveTutorCourse(TutorCourse tutorCourse) {
        return tutorCourseRepository.save(tutorCourse);
    }

    public TutorCourse findById(int id) {
        return tutorCourseRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("TutorCourse not found with ID :" + id));
    }

    //
//    public TutorCourse findById(int id) {
//        try {
//            return tutorCourseRepository.findById(id).orElseThrow();
//        } catch (Exception e) {
//            throw new RuntimeException("TutorCourse not found with ID: " + id, e);
//        }
//    }
    public List<TutorCourse> getAlltutorCourse() {
        return tutorCourseRepository.findAll();
    }

    public String deleteById(int id) {
        if (tutorCourseRepository.existsById(id)) {
            tutorCourseRepository.deleteById(id);
            return "TutorCourse deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("TutorCourse not found with ID: " + id);
        }
    }

    public TutorCourse updateById(final TutorCourse tutorCourse, final Integer id) {
        final Optional<TutorCourse> tutorCourseOptional = this.tutorCourseRepository.findById(id);
        if (tutorCourseOptional.isEmpty()) {
            throw new UserNotFoundException("TutorCourse not Found.");
        }
//        final TutorCourse tutorCourseObject = tutorCourseOptional.get();
//        if(tutor.getName()!= null){
//            tutorObject.setName(tutor.getName());
//        }
//
//        if(tutor.getEmail_id()!=null){
//            tutorObject.setEmail_id(tutor.getEmail_id());
//        }
//        if(tutor.getContact()!=0){
//            tutorObject.setContact(tutor.getContact());
//        }
        return null;
//                tutorRepository.save(tutorObject);
    }
}
