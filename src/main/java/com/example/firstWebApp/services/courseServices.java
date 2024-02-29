package com.example.firstWebApp.services;

import com.example.firstWebApp.entities.course;
import com.example.firstWebApp.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseServices {

   @Autowired
    private courseRepository courseRepository;

   public course addCourse(course c)
   {
        return  courseRepository.save(c);
   }

   public course findByName(String name)
   {
       return this.courseRepository.findCourseByName(name);
   }
}
