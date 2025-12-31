package com.smh.rest.webservices.restfulwebservices.self.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name="self_user")
public class SelfUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //@Size(min=3, max=100)
    private String name;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="BIRTH_DATE")
    private LocalDate birthDate;

    protected SelfUser() {

    }

    public SelfUser(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "SelfUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
