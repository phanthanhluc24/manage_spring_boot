package com.manage.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.manage.school.dto.req.TeacherRequestDTO;
import com.manage.school.models.Teacher;
import com.manage.school.services.TeacherService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService service;
    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherRequestDTO req){
        return service.addTeacher(req);
    }

    @PutMapping("/{id}")
    public Teacher editTeacher(@RequestBody TeacherRequestDTO req, @PathVariable Integer id){
        return service.editTeacher(req, id);
    }

    @GetMapping
    public Iterable<Teacher> findAll(){
        return service.findAll();
    }

    @PutMapping("delete/{id}")
    public Teacher deleteTeacher(@PathVariable Integer id){
        return service.deleteTeacher(id);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Integer id){
        return service.getTeacherById(id);
    }
}
