package com.manage.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manage.school.dto.req.StudentRequestDTO;
import com.manage.school.models.Student;
import com.manage.school.services.StudentService;
@Controller
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody StudentRequestDTO req){
        return service.addStudent(req);
    }
    @GetMapping
    public Iterable<Student> findAll(){
        return service.findAll();
    }
    @PutMapping("/{id}")
    public Student ediStudent(@RequestBody StudentRequestDTO req,@PathVariable Integer id){
        return service.editStudent(req, id);
    }
    @PutMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable Integer id) {
        return service.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return service.getStudentById(id);
    }
}
