package com.School_management.service;

import com.School_management.entity.Tutor;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {
    @Autowired
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor saveTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor findById(int id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Tutor not found with ID :" + id));
    }

    ////    public Tutor findById(int id) {
//        try {
//            return tutorRepository.findById(id).orElseThrow();
//        } catch (Exception e) {
//            throw new RuntimeException("Tutor not found with ID: " + id, e);
//        }
//    }
    public List<Tutor> getAlltutor() {
        return tutorRepository.findAll();
    }

    public String deleteById(int id) {
        if (tutorRepository.existsById(id)) {
            tutorRepository.deleteById(id);
            return "Tutor deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("Tutor not found with ID: " + id);
        }
    }

    public Tutor updateById(final Tutor tutor, final Integer id) {
        final Optional<Tutor> tutorOptional = this.tutorRepository.findById(id);
        if (tutorOptional.isEmpty()) {
            throw new UserNotFoundException("Tutor not Found.");
        }
        final Tutor tutorObject = tutorOptional.get();
        if (tutor.getName() != null) {
            tutorObject.setName(tutor.getName());
        }

        if (tutor.getEmailId() != null) {
            tutorObject.setEmailId(tutor.getEmailId());
        }
        if (tutor.getContact() != 0) {
            tutorObject.setContact(tutor.getContact());
        }
        return tutorRepository.save(tutorObject);
    }
}
