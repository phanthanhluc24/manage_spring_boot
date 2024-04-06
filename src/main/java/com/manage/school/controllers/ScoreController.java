package com.manage.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.school.dto.req.ScoreRequestDTO;
import com.manage.school.models.ScoreModel;
import com.manage.school.services.ScoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService service;

    @PostMapping("/{teacher_id}/{student_id}/{subject_id}")
    public ScoreModel addScore(@RequestBody ScoreRequestDTO request,@PathVariable Integer teacher_id,@PathVariable Integer student_id,@PathVariable Integer subject_id) {
        return service.addScore(request, teacher_id, student_id, subject_id);
    }
    
    @GetMapping("/{student_id}/{subject_id}")
    public ScoreModel findByStudentIdAndSubjectId(@PathVariable Integer student_id,@PathVariable Integer subject_id){
        return service.findByStudentIdAndSubjectId(student_id, subject_id);
    }
}
