package com.gmu.tutors.services;

import com.gmu.tutors.domain.JpaTutor;
import com.gmu.tutors.repository.TutorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
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
}
