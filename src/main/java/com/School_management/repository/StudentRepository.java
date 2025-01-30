package com.School_management.repository;

import com.School_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM Student WHERE firstName = :name", nativeQuery = true)
    List<Student> getByFirstName(@Param("name") String name);

    @Query(value = "SELECT s FROM Student s " +
            "JOIN s.school sc " +
            "WHERE (:search IS NULL OR " +
            "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(s.emailId) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(sc.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(sc.address) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Student> getBySearch(@Param("search") String search);
}

