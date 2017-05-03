package com.gmu.tutors;

import com.gmu.tutors.transfer.dto.Location;
import com.gmu.tutors.transfer.enums.TutorLocation;
import com.gmu.tutors.transfer.enums.TutorSubject;
import com.gmu.tutors.util.CalendarUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import com.gmu.tutors.transfer.dto.Tutor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andrew on 4/22/2017.
 */
public class TutorTest {
    @Test
    public void constructor(){
        Tutor tutor = new Tutor();
        assertTrue(tutor != null);
    }

    @Test
    public void setValues(){
        Tutor tutor = new Tutor();

        tutor.setFirstName("Andrew");
        assertEquals("Andrew", tutor.getFirstName());

        tutor.setLastName("Huynh");
        assertEquals("Huynh", tutor.getLastName());

        // full name is a method that concatenates last and first names.
        assertEquals("Huynh, Andrew", tutor.getFullName());

        DateTime start = new DateTime().withYear(2017).withMonthOfYear(1).withDayOfMonth(1);
        DateTime end = new DateTime().withYear(2017).withMonthOfYear(12).withDayOfMonth(31);
        tutor.setStart(start);
        tutor.setEnd(end);
        assertEquals(start, tutor.getStart());
        assertEquals(end, tutor.getEnd());

        tutor.setRating(new BigDecimal(10.0));
        assertEquals(new BigDecimal(10.0), tutor.getRating());

        List<TutorSubject> subjects = Arrays.asList(TutorSubject.COMPSCI, TutorSubject.MATH, TutorSubject.MUSIC);
        tutor.setSubjects(subjects);
        assertEquals(subjects, tutor.getSubjects());

        List<Location> locations = Arrays.asList(
                new Location(TutorLocation.Engineering, TutorLocation.Engineering.description()),
                new Location(TutorLocation.Fenwick, TutorLocation.Fenwick.description()),
                new Location(TutorLocation.UserDefined, "Home")
        );
        tutor.setLocations(locations);
        assertEquals(locations, tutor.getLocations());

        DateTime time = new DateTime();
        assertTrue(CalendarUtils.isAvailable(time, tutor));
        tutor.setAvailable(CalendarUtils.isAvailable(time, tutor));
        assertTrue(tutor.isAvailable());
    }
}
