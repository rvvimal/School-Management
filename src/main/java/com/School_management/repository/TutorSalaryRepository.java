package com.School_management.repository;

import com.School_management.entity.TutorSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorSalaryRepository extends JpaRepository<TutorSalary, Integer> {
}
