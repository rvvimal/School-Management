package com.School_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "student")

public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private long contact;
    private String enrollementDate;

    @ManyToOne()
    @JoinColumn(name = "schoolId")
    private School school;
//    public School getSchool() {
//        return school;
//    }
//
//    public void setSchool(School school) {
//        this.school = school;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getfirstName() {
//        return firstName;
//    }
//
//    public void setFirst_name(String FirstName) {
//        firstName = FirstName;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getEmail_id() {
//        return email_id;
//    }
//
//    public void setEmail_id(String email_id) {
//        this.email_id = email_id;
//    }
//
//    public long getContact() {
//        return contact;
//    }
//
//    public void setContact(long contact) {
//        this.contact = contact;
//    }
//
//    public String getEnrollement_date() {
//        return enrollement_date;
//    }
//
//    public void setEnrollement_date(String enrollement_date) {
//        this.enrollement_date = enrollement_date;
//    }
}
