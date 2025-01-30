package com.School_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tutorSalary")
public class TutorSalary {
    @Id
    private int id;
    private String paymentMonth;
    private String salaryPaid;
    private double salaryAmount;
    @ManyToOne()
    @JoinColumn(name = "tutorId")
    private Tutor tutor;
//
//    public Tutor getTutor() {
//        return tutor;
//    }
//
//    public void setTutor(Tutor tutor) {
//        this.tutor = tutor;
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
//    public String getPayment_moth() {
//        return payment_moth;
//    }
//
//    public void setPayment_moth(String payment_moth) {
//        this.payment_moth = payment_moth;
//    }
//
//    public String getSalary_paid() {
//        return salary_paid;
//    }
//
//    public void setSalary_paid(String salary_paid) {
//        this.salary_paid = salary_paid;
//    }
//
//    public double getSalary_amount() {
//        return salary_amount;
//    }
//
//    public void setSalary_amount(double salary_amount) {
//        this.salary_amount = salary_amount;
//    }
//

}
