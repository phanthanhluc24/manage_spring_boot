package com.manage.school.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manage.school.models.ScoreModel;
import com.manage.school.models.Student;
import com.manage.school.models.SubjectModel;
@Repository
public interface ScoreRepository extends JpaRepository<ScoreModel,Integer>{
    @Query("SELECT s FROM ScoreModel s WHERE s.student_id = ?1 AND s.subject_id = ?2")
    ScoreModel findByStudentIdAndSubjectId(Student student, SubjectModel subject);
}
