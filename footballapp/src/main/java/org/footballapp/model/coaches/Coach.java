package org.footballapp.model.coaches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coach {

    private int id;

    private String name;

    private String firstname;

    private String lastname;

    private int age;

    private CoachBirth birth;

    private String nationality;

    private String height;

    private String weight;

    private String photo;

    private CoachTeam team;

    private List<CoachCareer> career;

    public Coach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CoachBirth getBirth() {
        return birth;
    }

    public void setBirth(CoachBirth birth) {
        this.birth = birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public CoachTeam getTeam() {
        return team;
    }

    public void setTeam(CoachTeam team) {
        this.team = team;
    }

    public List<CoachCareer> getCareer() {
        return career;
    }

    public void setCareer(List<CoachCareer> career) {
        this.career = career;
    }
}