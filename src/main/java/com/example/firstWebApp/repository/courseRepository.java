package com.example.firstWebApp.repository;

import com.example.firstWebApp.entities.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface courseRepository extends JpaRepository<course,Long> {

    @Query("SELECT c FROM course c WHERE c.courseName = :name")
    public course findCourseByName(String name);
}
