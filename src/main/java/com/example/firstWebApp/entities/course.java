package com.example.firstWebApp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private int numberStudent;
    private String courseName;
    private String  teacherName;
    private int numberLesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }

    public course() {
    }
}
