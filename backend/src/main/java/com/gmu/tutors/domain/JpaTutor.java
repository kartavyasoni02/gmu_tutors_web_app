package com.gmu.tutors.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JpaTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer numOfRatings; // we aren't keeping track of all of the ratings, so we need to keep track of how many

    public static JpaTutor instance() {
        return new JpaTutor();
    }

    protected JpaTutor() {}

    public JpaTutor(String firstName, String lastName, Double rating, Integer numOfRatings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.numOfRatings = numOfRatings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(Integer numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("rating", rating)
                .append("numOfRatings", numOfRatings)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        JpaTutor tutor = (JpaTutor) o;

        return new EqualsBuilder()
                .append(id, tutor.id)
                .append(firstName, tutor.firstName)
                .append(lastName, tutor.lastName)
                .append(rating, tutor.rating)
                .append(numOfRatings, tutor.numOfRatings)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(rating)
                .append(numOfRatings)
                .toHashCode();
    }
}
