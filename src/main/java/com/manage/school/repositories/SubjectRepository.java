package com.manage.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.school.models.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel,Integer>{
    
}
