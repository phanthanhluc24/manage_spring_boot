package com.manage.school.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequestDTO {
    private Integer subject_id;
    private Integer student_class;
    private String full_name;
    private Integer year_of_birth;
    private String province;
    private String gender;
    private String password;
    private float salary;
    private String subject;
}
