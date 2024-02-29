package com.example.firstWebApp.repository;

import com.example.firstWebApp.entities.videoLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface videoRepository extends JpaRepository<videoLesson,Long> {
}
