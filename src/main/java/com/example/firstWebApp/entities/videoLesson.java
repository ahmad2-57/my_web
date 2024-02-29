package com.example.firstWebApp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="videos")
public class videoLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String  authorName;
    private String  videoLink;
    private  int numOfLikes;


    public videoLesson() {
    }

    public videoLesson(Long id, String authorName, String videoLink, int numOfLikes, String[] comments) {
        this.id = id;
        this.authorName = authorName;
        this.videoLink = videoLink;
        this.numOfLikes = numOfLikes;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

}
