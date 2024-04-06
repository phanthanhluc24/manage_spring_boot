package com.manage.school.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "teachers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher extends User{
    private float salary;
    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private SubjectModel subject_id;
}
