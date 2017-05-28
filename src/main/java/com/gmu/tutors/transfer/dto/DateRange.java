package com.gmu.tutors.transfer.dto;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by Andrew on 5/10/2017.
 *
 * Range of 2 dates that are used to determine availability of a tutor.
 * Note: 2 date ranges for the same tutor should NEVER overlap
 */
public class DateRange implements Serializable {

    private DateTime start;
    private DateTime end;
    private String tutorId; //linked to a tutor by ID? Maybe? Not sure yet

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
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
