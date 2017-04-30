package com.gmu.tutors.transfer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by Andrew on 4/29/2017.
 *
 * reading guide for MongoDB integration
 * url: https://spring.io/guides/gs/accessing-mongodb-data-rest/
 */
@Document(collection = "tutor")
@TypeAlias(value = "tutor")
public class MongoTutor {
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
