package com.manage.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.school.models.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    Iterable<Student> findByStatus(String status);
}
