package com.gmu.tutors.services;

import com.gmu.tutors.domain.JpaTutor;
import com.gmu.tutors.repository.TutorRepository;
import com.gmu.tutors.transfer.dto.Tutor;
import com.gmu.tutors.transfer.enums.TutorSubject;
import com.gmu.tutors.util.CalendarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> getDummyTutorList(){
        // dummy
        Tutor dummy = new Tutor();
        dummy.setFirstName("Andrew");
        dummy.setLastName("Huynh");
        dummy.setStart(ZonedDateTime.of(2017, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
        dummy.setEnd(ZonedDateTime.of(2017, 2, 2, 2, 2, 2, 2, ZoneId.systemDefault()));
        dummy.setRating(9.5);
        dummy.setSubjects(Arrays.asList(TutorSubject.COMPSCI, TutorSubject.MATH, TutorSubject.IT));
        dummy.setAvailable(CalendarUtils.isAvailable(ZonedDateTime.of(2017, 1, 5, 1, 1, 1, 1, ZoneId.systemDefault()), dummy));
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(dummy);

        return tutors;
    }

    public String insertTutor(Tutor tutor){
        JpaTutor jpaTutor = new JpaTutor(
                tutor.getFirstName(),
                tutor.getLastName(),
                tutor.getRating(),
                tutor.getRating() != null ? 1 : 0
        );
        tutorRepository.save(jpaTutor); //assumes that this tutor doesn't exist yet. Can yield duplicates

        return String.format("Successfully saved %s, %s", tutor.getLastName(), tutor.getFirstName());
    }

    public String updateRating(Long tutorId, Double rating){
        JpaTutor tutor = tutorRepository.findOne(tutorId);
        double currentRating = calculateNewAverageRating(tutor.getRating(), tutor.getNumOfRatings(), rating);

        tutor.setRating(currentRating);
        tutor.setNumOfRatings(tutor.getNumOfRatings() + 1);
        tutorRepository.save(tutor);

        return String.format("%s, %s has an overall rating of %f", tutor.getLastName(), tutor.getFirstName(), currentRating);
    }

    private double calculateNewAverageRating(double oldRating, int numberOfRatings, double newRating) {
        return ((oldRating * numberOfRatings) + newRating) / (numberOfRatings + 1);
    }
}
