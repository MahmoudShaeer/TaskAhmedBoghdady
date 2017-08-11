package com.example.mahmoudshaeer.taskahmedboghdady.model.apiResponse;

/**
 * Created by Mahmoud Shaeer on 11/08/2017.
 */

public class Results {

    private String course_name;
    private String t_result_value;
    private String t_result_total;
    private String term;
    private String teacher_name;

    public Results() {
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setT_result_value(String t_result_value) {
        this.t_result_value = t_result_value;
    }

    public void setT_result_total(String t_result_total) {
        this.t_result_total = t_result_total;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getT_result_value() {
        return t_result_value;
    }

    public String getT_result_total() {
        return t_result_total;
    }

    public String getTerm() {
        return term;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public Results(String course_name, String t_result_value, String t_result_total, String term, String teacher_name) {
        this.course_name = course_name;
        this.t_result_value = t_result_value;
        this.t_result_total = t_result_total;
        this.term = term;
        this.teacher_name = teacher_name;
    }
}
