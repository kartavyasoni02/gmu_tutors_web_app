package com.gmu.tutors.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by Andrew on 5/10/2017.
 *
 * Range of 2 dates that are used to determine availability of a tutor.
 * Note: 2 date ranges for the same tutor should NEVER overlap
 */
public class DateRange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String tutorId; //linked to tutors by their UUID

    protected DateRange() {
    }

    public DateRange(ZonedDateTime start, ZonedDateTime end, String tutorId) {
        this.start = start;
        this.end = end;
        this.tutorId = tutorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("start", start)
                .append("end", end)
                .append("tutorId", tutorId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DateRange dateRange = (DateRange) o;

        return new EqualsBuilder()
                .append(id, dateRange.id)
                .append(start, dateRange.start)
                .append(end, dateRange.end)
                .append(tutorId, dateRange.tutorId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(start)
                .append(end)
                .append(tutorId)
                .toHashCode();
    }
}
