package com.manage.school.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "students")
public class Student extends User{
    @ManyToOne
    @JoinColumn(name = "student_class",referencedColumnName = "id")
    private ClassModel student_class;
}
