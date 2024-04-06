package com.manage.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.school.models.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Iterable<Teacher> findByStatus(String status);
}
