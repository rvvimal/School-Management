package com.School_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tutorCourse")
public class TutorCourse {
    @Id
    private int id;
    @ManyToOne()
    @JoinColumn(name = "courseId")
    private Course course;
    @ManyToOne()
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

//    public Tutor getTutor() {
//        return tutor;
//    }
//
//    public void setTutor(Tutor tutor) {
//        this.tutor = tutor;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
