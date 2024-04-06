package com.manage.school.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class SubjectModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
}
