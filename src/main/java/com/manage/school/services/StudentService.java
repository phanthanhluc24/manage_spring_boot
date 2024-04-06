package com.manage.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.manage.school.dto.req.StudentRequestDTO;
import com.manage.school.models.ClassModel;
import com.manage.school.models.Student;
import com.manage.school.repositories.ClassRepository;
import com.manage.school.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    @Autowired
    private ClassRepository classRepo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public Student addStudent(StudentRequestDTO request) {
        Optional<ClassModel> classId = classRepo.findById(request.getStudent_class());
        ClassModel classModel=classId.get();
        Student student = new Student();
        student.setStudent_class(classModel);
        student.setFull_name(request.getFull_name());
        student.setYear_of_birth(request.getYear_of_birth());
        student.setProvince(request.getProvince());
        student.setGender(request.getGender());
        String hashPassword=encoder.encode(request.getPassword());
        student.setPassword(hashPassword);
        return repo.save(student);
    }

    public Iterable<Student> findAll(){
        return repo.findByStatus("active");
    }

    public Student editStudent(StudentRequestDTO request,Integer Id){
        Optional<Student> stuId = repo.findById(Id);
        boolean checkId=stuId.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
        }
        Optional<ClassModel> classId = classRepo.findById(request.getStudent_class());
        boolean checkIdClass=classId.isPresent();
        if (!checkIdClass) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Class not found");
        }
        ClassModel classModel=classId.get();
        Student student =stuId.get();
        student.setStudent_class(classModel);
        student.setFull_name(request.getFull_name());
        student.setYear_of_birth(request.getYear_of_birth());
        student.setProvince(request.getProvince());
        student.setGender(request.getGender());
        String hashPassword=encoder.encode(request.getPassword());
        student.setPassword(hashPassword);
        return repo.save(student);
    }

    public Student deleteStudent(Integer id){
        Optional<Student> stuId = repo.findById(id);
        boolean checkId=stuId.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found");
        }

        Student student=stuId.get();
        student.setStatus("inactive");
        return repo.save(student);
    }

    public Student getStudentById(Integer id){
        Optional<Student> student=repo.findById(id);
        boolean checkId=student.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found");
        }
        return student.get();
    }
}
