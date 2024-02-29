//user

package com.example.firstWebApp.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phoneNumber;
    private int cont_use;

    public user() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCont_use() {
        return cont_use;
    }

    public void setCont_use(int cont_use) {
        this.cont_use = cont_use;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public user(Long id, String name, String email, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cont_use=0;
    }

    public user(Long id, String name, String email, String password, String phoneNumber, int cont_use) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cont_use = cont_use;
    }
}

