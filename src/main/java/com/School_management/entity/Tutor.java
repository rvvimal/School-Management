package com.School_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tutor")
public class Tutor {
    @Id
    private int id;
    private String name;
    private String emailId;
    private long contact;
    @ManyToOne()
    @JoinColumn(name = "schoolId")
    private School school;
//
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
//    public String getName() {
//        return a_name;
//    }
//
//    public void setName(String name) {
//        this.a_name = name;
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
}
