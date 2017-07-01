package com.gmu.tutors.transfer.dto;

import com.gmu.tutors.transfer.enums.TutorSubject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class Tutor {
    private String firstName;
    private String lastName;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private BigDecimal rating; //average of all ratings. Range: 0-10
    private List<TutorSubject> subjects;
    private List<Location> locations;
    private boolean available;

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

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public List<TutorSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TutorSubject> subjects) {
        this.subjects = subjects;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        return new EqualsBuilder()
                .append(available, tutor.available)
                .append(firstName, tutor.firstName)
                .append(lastName, tutor.lastName)
                .append(start, tutor.start)
                .append(end, tutor.end)
                .append(rating, tutor.rating)
                .append(subjects, tutor.subjects)
                .append(locations, tutor.locations)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(start)
                .append(end)
                .append(rating)
                .append(subjects)
                .append(locations)
                .append(available)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("start", start)
                .append("end", end)
                .append("rating", rating)
                .append("subjects", subjects)
                .append("locations", locations)
                .append("available", available)
                .toString();
    }
}
