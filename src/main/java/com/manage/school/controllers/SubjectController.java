package com.manage.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.school.dto.req.SubjectRequestDTO;
import com.manage.school.models.SubjectModel;
import com.manage.school.services.SubjectService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService service;

    @PostMapping
    public SubjectModel addSubject(@RequestBody SubjectRequestDTO request){
        return service.addSubject(request);
    }

    @GetMapping
    public Iterable<SubjectModel> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public SubjectModel editSubject(@PathVariable Integer id, @RequestBody SubjectRequestDTO request) {
        return service.editSubject(request,id);
    }
}