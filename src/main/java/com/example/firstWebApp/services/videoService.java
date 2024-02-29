package com.example.firstWebApp.services;

import com.example.firstWebApp.entities.videoLesson;
import com.example.firstWebApp.repository.videoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class videoService {
    @Autowired
    private videoRepository videoRepository;

    public videoLesson addVideo(videoLesson video)
    {
        return videoRepository.save(video);
    }

}
