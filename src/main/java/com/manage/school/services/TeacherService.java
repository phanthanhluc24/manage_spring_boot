package com.manage.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.manage.school.dto.req.TeacherRequestDTO;
import com.manage.school.models.SubjectModel;
import com.manage.school.models.Teacher;
import com.manage.school.repositories.SubjectRepository;
import com.manage.school.repositories.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository repo;
    @Autowired
    SubjectRepository repoSubject;
    private final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(); 
    public ResponseEntity<Teacher> addTeacher(TeacherRequestDTO request){
        Optional<SubjectModel> subId=repoSubject.findById(request.getSubject_id());
        boolean idSubject=subId.isPresent();
        if (!idSubject) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Subject not found");
        }
        SubjectModel subject_id=subId.get();
        Teacher teacher=new Teacher();
        teacher.setFull_name(request.getFull_name());
        teacher.setGender(request.getGender());
        teacher.setProvince(request.getProvince());
        teacher.setSalary(request.getSalary());
        teacher.setYear_of_birth(request.getYear_of_birth());
        teacher.setSubject_id(subject_id);
        String hashPassword=bCryptPasswordEncoder.encode(request.getPassword());
        teacher.setPassword(hashPassword);
        Teacher saveTeacher= repo.save(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(saveTeacher);
    }

    public Teacher editTeacher(TeacherRequestDTO request,Integer Id){
        Optional<Teacher> TeacherId=repo.findById(Id);
        boolean checkId=TeacherId.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Teacher not found");
        }
        Optional<SubjectModel> subId = repoSubject.findById(request.getSubject_id());
        boolean checkSubject=subId.isPresent();
        if (!checkSubject) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Subject not found");
        }
        SubjectModel idSubject=subId.get();
        Teacher teacher=TeacherId.get();
        teacher.setFull_name(request.getFull_name());
        teacher.setYear_of_birth(request.getYear_of_birth());
        teacher.setProvince(request.getProvince());
        teacher.setGender(request.getGender());
        String hashPassword=bCryptPasswordEncoder.encode(request.getPassword());
        teacher.setPassword(hashPassword);
        teacher.setSalary(request.getSalary());
        teacher.setSubject_id(idSubject);
        return repo.save(teacher);
    }

    public Iterable<Teacher> findAll(){
        return repo.findByStatus("active");
    }

    public Teacher deleteTeacher(Integer id){
        Optional<Teacher> teacherId = repo.findById(id);
        boolean checkId=teacherId.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Teacher not found");
        }
        Teacher teacher=teacherId.get();
        teacher.setStatus("inactive");
        return repo.save(teacher);
    }

    public Teacher getTeacherById(Integer id){
        Optional<Teacher> teacher=repo.findById(id);
        boolean checkId=teacher.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Teacher not found");
        }
        return teacher.get();
    }
}
