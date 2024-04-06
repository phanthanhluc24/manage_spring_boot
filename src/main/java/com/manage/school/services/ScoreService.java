package com.manage.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.manage.school.dto.req.ScoreRequestDTO;
import com.manage.school.models.ScoreModel;
import com.manage.school.models.Student;
import com.manage.school.models.SubjectModel;
import com.manage.school.models.Teacher;
import com.manage.school.repositories.ScoreRepository;
import com.manage.school.repositories.StudentRepository;
import com.manage.school.repositories.SubjectRepository;
import com.manage.school.repositories.TeacherRepository;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository repoScore;
    @Autowired
    TeacherRepository repoTeacher;
    @Autowired
    StudentRepository repoStudent;
    @Autowired
    SubjectRepository repoSubject;
    public ScoreModel addScore(ScoreRequestDTO request,Integer teacher_id,Integer student_id,Integer subject_id){
        Optional<Teacher> teacherId=repoTeacher.findById(teacher_id);
        boolean checkTeacher=teacherId.isPresent();
        if(!checkTeacher){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"teacher not found");
        }
        Optional<Student> studentId=repoStudent.findById(student_id);
        boolean checkStudent=studentId.isPresent();
        if(!checkStudent){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
        }Optional<SubjectModel> subjectId=repoSubject.findById(subject_id);
        boolean checkSubject=subjectId.isPresent();
        if(!checkSubject){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"subject not found");
        }
        Teacher id_teacher=teacherId.get();
        Student id_student=studentId.get();
        SubjectModel id_subject=subjectId.get();
        ScoreModel score=new ScoreModel();
        score.setTeacher_id(id_teacher);
        score.setStudent_id(id_student);
        score.setSubject_id(id_subject);
        score.setOral_test(request.getOral_test());
        score.setFifteen_min_test(request.getFifteen_min_test());
        score.setMid_term_test(request.getMid_term_test());
        score.setSemester_exam(request.getSemester_exam());
        return repoScore.save(score);
    }

    public ScoreModel findByStudentIdAndSubjectId(Integer student_id,Integer subject_id){
        Optional<Student> studentId=repoStudent.findById(student_id);
        boolean checkStudent=studentId.isPresent();
        if(!checkStudent){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
        }Optional<SubjectModel> subjectId=repoSubject.findById(subject_id);
        boolean checkSubject=subjectId.isPresent();
        if(!checkSubject){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"subject not found");
        }
        ScoreModel totalScore= repoScore.findByStudentIdAndSubjectId(studentId.get(), subjectId.get());
        // float total=0;
        // for (ScoreModel score : totalScore) {
        //     float oralTest=score.getOral_test();
        //     float fifteenMinTest =score.getFifteen_min_test();
        //     float midTermTest= score.getMid_term_test();
        //     float semesterExam = score.getSemester_exam();
        //     float totalScoreSubject=(oralTest+fifteenMinTest+midTermTest+semesterExam)/7;
        //     total+=totalScoreSubject;
        // }

        return totalScore;
    }
}
