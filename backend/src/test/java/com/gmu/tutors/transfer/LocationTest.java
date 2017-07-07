package com.gmu.tutors.transfer;

import com.gmu.tutors.transfer.dto.Location;
import com.gmu.tutors.transfer.enums.TutorLocation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class LocationTest {
    private static final Logger log = LoggerFactory.getLogger(LocationTest.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void oneArgumentConstructorSetsValuesCorrectly() {
        Location location = new Location(TutorLocation.Engineering);
        assertThat(location.getLocationValue(), is(equalTo(TutorLocation.Engineering)));
        assertThat(location.getDescription(), is(equalTo(TutorLocation.Engineering.description())));
    }

    @Test
    public void twoArgumentConstructorSetsValuesCorrectly() {
        String description = "GMU Exploratory Building";
        Location location = new Location(TutorLocation.Exploratory, description);
        assertThat(location.getLocationValue(), is(equalTo(TutorLocation.Exploratory)));
        assertThat(location.getDescription(), is(equalTo(description)));
    }

    @Test
    public void userDefinedLocationWithNoDescriptionThrowsException() {
        expectedException.expect(IllegalArgumentException.class);
        new Location(TutorLocation.UserDefined);
    }
}
