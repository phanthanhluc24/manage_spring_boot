package com.manage.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.school.dto.req.ClassRequestDTO;
import com.manage.school.models.ClassModel;
import com.manage.school.repositories.ClassRepository;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repo;

    public ClassModel addClass(ClassRequestDTO request){
        ClassModel model=new ClassModel();
        model.setClass_name(request.getClass_name());
        return repo.save(model);
    }

    public Iterable<ClassModel> findAll(){
        return repo.findAll();
    }
}
