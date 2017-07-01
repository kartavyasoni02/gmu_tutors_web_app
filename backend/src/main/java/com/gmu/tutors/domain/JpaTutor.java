package com.gmu.tutors.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class JpaTutor {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private Integer numOfRatings; // we aren't keeping track of all of the ratings, so we need to keep track of how many

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(Integer numOfRatings) {
        this.numOfRatings = numOfRatings;
    }
}
