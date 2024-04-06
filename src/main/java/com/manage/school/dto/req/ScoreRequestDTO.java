package com.manage.school.dto.req;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreRequestDTO {
    private float oral_test;
    private float fifteen_min_test;
    private float mid_term_test;
    private float semester_exam;
}
