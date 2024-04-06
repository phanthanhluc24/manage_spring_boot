package com.manage.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.school.models.ClassModel;

public interface ClassRepository extends JpaRepository<ClassModel, Integer> {
    
}
