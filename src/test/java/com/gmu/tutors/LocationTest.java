package com.gmu.tutors;

import com.gmu.tutors.transfer.dto.Location;
import com.gmu.tutors.transfer.enums.TutorLocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Andrew on 5/2/2017.
 */
public class LocationTest {
    @Test
    public void testAll(){
        // happy path - 1 param constructor
        Location location1 = new Location(TutorLocation.Engineering);
        assertEquals(TutorLocation.Engineering, location1.getLocationValue());
        assertEquals(TutorLocation.Engineering.description(), location1.toString());

        // happy path - 2 param constructor
        Location location2 = new Location(TutorLocation.Exploratory, "GMU Engineering");
        assertEquals("GMU Engineering", location2.getDescription());
        assertEquals(TutorLocation.Engineering, location2.getLocationValue());
        assertEquals("GMU Engineering", location2.toString());

        // exceptional path
        try {
            Location location3 = new Location(TutorLocation.UserDefined);
            fail("Should throw an IllegalArgumentException because UserDefined enum values require a description");
        } catch (IllegalArgumentException e) {}
    }
}
