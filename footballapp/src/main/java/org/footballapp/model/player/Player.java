package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a football player returned by API-Football.
 *
 * This model contains player identity information only.
 * Season statistics are stored separately.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @JsonProperty("id")
    private int playerId;

    private String name;
    private String firstname;
    private String lastname;

    private Integer age;

    private String nationality;

    private String height;
    private String weight;

    private boolean injured;

    @JsonProperty("photo")
    private String photoUrl;

    private PlayerBirth birth;

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public PlayerBirth getBirth() {
        return birth;
    }

    public void setBirth(PlayerBirth birth) {
        this.birth = birth;
    }
}