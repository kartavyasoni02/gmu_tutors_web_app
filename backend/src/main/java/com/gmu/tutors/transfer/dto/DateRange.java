package com.gmu.tutors.transfer.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by Andrew on 5/10/2017.
 *
 * Range of 2 dates that are used to determine availability of a tutor.
 * Note: 2 date ranges for the same tutor should NEVER overlap
 */
public class DateRange implements Serializable {

    private ZonedDateTime start;
    private ZonedDateTime end;
    private String tutorId; //linked to a tutor by ID? Maybe? Not sure yet

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
        return "DateRange{" +
                "start=" + start +
                ", end=" + end +
                ", tutorId='" + tutorId + '\'' +
                '}';
    }
}
