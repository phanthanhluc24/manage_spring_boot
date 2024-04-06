package com.manage.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.school.dto.req.ClassRequestDTO;
import com.manage.school.models.ClassModel;
import com.manage.school.services.ClassService;
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService service;
    @PostMapping
    public ClassModel addClass(@RequestBody ClassRequestDTO request){
        return service.addClass(request);
    }
    @GetMapping
    public Iterable<ClassModel> findAll(){
        return service.findAll();
    }
}
