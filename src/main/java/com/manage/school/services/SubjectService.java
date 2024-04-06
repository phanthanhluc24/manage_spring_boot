package com.manage.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.manage.school.dto.req.SubjectRequestDTO;
import com.manage.school.models.SubjectModel;
import com.manage.school.repositories.SubjectRepository;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository repo;

    public SubjectModel addSubject(SubjectRequestDTO request){
        SubjectModel subject=new SubjectModel();
        subject.setSubject(request.getSubject());
        return repo.save(subject);
    }

    public Iterable<SubjectModel> findAll(){
        return repo.findAll();
    }

    public SubjectModel editSubject(SubjectRequestDTO request,Integer id){
        Optional<SubjectModel> subjectId=repo.findById(id);
        boolean checkId=subjectId.isPresent();
        if (!checkId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Subject not found");
        }
        SubjectModel subject=subjectId.get();
        subject.setSubject(request.getSubject());
        return repo.save(subject);
    }
}
