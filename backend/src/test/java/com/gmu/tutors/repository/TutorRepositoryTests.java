package com.gmu.tutors.repository;

import com.gmu.tutors.domain.JpaTutor;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorRepositoryTests {
    private static final Logger log = LoggerFactory.getLogger(TutorRepositoryTests.class);

    @Autowired
    private TutorRepository tutorRepository;

    @After
    public void tearDown() {
        tutorRepository.deleteAll();
    }

    @Test
    public void repositorySavesTutorsCorrectly() {
        JpaTutor geoff = new JpaTutor("Geoff", "Ramsey", 10.0, 620);
        JpaTutor result = tutorRepository.save(geoff);

        assertThat(result.getFirstName(), is(equalTo(geoff.getFirstName())));
        assertThat(result.getLastName(), is(equalTo(geoff.getLastName())));
        assertThat(result.getRating(), is(equalTo(geoff.getRating())));
        assertThat(result.getNumOfRatings(), is(equalTo(geoff.getNumOfRatings())));
        assertThat(result.getId(), is(not(nullValue())));
    }

    @Test
    public void repositoryFetchesByLastName() {
        JpaTutor geoff = new JpaTutor("Geoff", "Ramsey", 10.0, 620);
        tutorRepository.save(geoff);
        List<JpaTutor> result = tutorRepository.findByLastName("Ramsey");

        assertThat(result, hasSize(1));
        assertThat(result.get(0).getFirstName(), is(equalTo(geoff.getFirstName())));
        assertThat(result.get(0).getLastName(), is(equalTo(geoff.getLastName())));
        assertThat(result.get(0).getId(), is(not(nullValue())));
    }

    @Test
    public void repositoryFetchesTutorsWithinRatingRange() {
        JpaTutor geoff = new JpaTutor("Geoff", "Ramsey", 10.0, 620);
        JpaTutor griffon = new JpaTutor("Griffon", "Ramsey", 9.2, 50);
        JpaTutor bruce = new JpaTutor("Bruce", "Greene", 8.9, 128);
        JpaTutor jack = new JpaTutor("Jack", "Patillo", 3.1, 8945);
        tutorRepository.save(Arrays.asList(geoff, griffon, bruce, jack));

        double lowerBound = 5.0;
        double upperBound = 9.5;
        List<JpaTutor> result = tutorRepository.findByRatingBetween(lowerBound, upperBound);
        assertThat(result, hasSize(2));
        result.forEach(tutor -> {
            assertThat(tutor.getRating(), is(greaterThan(lowerBound)));
            assertThat(tutor.getRating(), is(lessThan(upperBound)));
        });
    }
}
