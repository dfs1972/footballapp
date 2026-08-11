package org.footballapp.model.squad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SquadPlayer {

    private int id;

    private String name;

    private Integer age;

    private Integer number;

    private String position;

    private String photo;

    public SquadPlayer() {
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

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(
            Integer age
    ) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(
            Integer number
    ) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(
            String position
    ) {
        this.position = position;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(
            String photo
    ) {
        this.photo = photo;
    }
}