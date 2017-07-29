package com.gmu.tutors.services;

import com.gmu.tutors.domain.JpaTutor;
import com.gmu.tutors.repository.TutorRepository;
import com.gmu.tutors.transfer.dto.Tutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorServiceTests {
    private static final Logger log = LoggerFactory.getLogger(TutorServiceTests.class);

    @MockBean
    private TutorRepository tutorRepository;

    @Autowired
    private TutorService tutorService;

    @Test
    public void updatingTutorRatingCalculatesCorrectly() {
        JpaTutor tutor = new JpaTutor("Geoff", "Ramsey", 10.0, 1);
        when(tutorRepository.findOne(1L)).thenReturn(tutor);
        double expectedAverage = 9.5;
        double rating = 9.0;
        String actualOutput = tutorService.updateRating(1L, rating);
        String expectedOutput = String.format("%s, %s has an overall rating of %f", tutor.getLastName(), tutor
                .getFirstName(), expectedAverage);
        assertThat(actualOutput, is(equalTo(expectedOutput)));
    }

    @Test
    public void insertingTutorReturnsCorrectMessage() {
        String firstName = "Andrew";
        String lastName = "Huynh";
        String message = String.format("Successfully saved %s, %s", lastName, firstName);

        Tutor tutor = new Tutor();
        tutor.setFirstName(firstName);
        tutor.setLastName(lastName);

        String output = tutorService.insertTutor(tutor);
        assertThat(output, is(equalTo(message)));
    }

    @Test
    public void updatingRatingCalculatesCorrectly() {
        double[] oldRatings = {1.0, 3.0, 6.5, 9.0};
        int[] numOfRatings = {5, 5, 10, 40};
        double[] newRatings = {5.0, 2.0, 8.0, 10.0};
        double[] expectedOutput = {10.0 / 6.0, 17.0 / 6.0, 73.0 / 11.0, 370.0 / 41.0};
        double error = 0.000005;

        for (int i = 0; i < oldRatings.length; i++) {
            double calculatedValue = tutorService.calculateNewAverageRating(oldRatings[i], numOfRatings[i], newRatings[i]);
            assertThat(calculatedValue, is(closeTo(expectedOutput[i], error)));
        }
    }
}
