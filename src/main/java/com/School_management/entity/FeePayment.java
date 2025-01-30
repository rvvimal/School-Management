package com.School_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name = "feePayment")
@Entity
@Setter
@Getter
public class FeePayment {
    @Id
    private int id;
    private Date date;
    private String term;
    private double feeAmount;
    private String Astatus;
    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
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
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public double getFeeAmount() {
//        return feeAmount;
//    }
//
//    public void setFeeAmount(double feeAmount) {
//        this.feeAmount = feeAmount;
//    }
//
//    public String getAstatus() {
//        return Astatus;
//    }
//
//    public void setAstatus(String Astatus) {
//        this.Astatus = Astatus;
//    }
//
//    public String getTerm() {
//        return term;
//    }
//
//    public void setTerm(String term) {
//        this.term = term;
//    }

}
