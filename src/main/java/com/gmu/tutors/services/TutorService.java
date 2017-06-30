package com.gmu.tutors.services;

import com.gmu.tutors.domain.JpaTutor;
import com.gmu.tutors.repository.TutorRepository;
import com.gmu.tutors.transfer.dto.Tutor;
import com.gmu.tutors.transfer.enums.TutorSubject;
import com.gmu.tutors.util.CalendarUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew on 4/21/2017.
 */
@Transactional
@Service
public class TutorService {
    private Logger log = LoggerFactory.getLogger(TutorService.class);

    @Autowired
    TutorRepository tutorRepository;

    public List<Tutor> getAllTutors(){
        // dummy
        Tutor dummy = new Tutor();
        dummy.setFirstName("Andrew");
        dummy.setLastName("Huynh");
        dummy.setStart(ZonedDateTime.of(2017, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()));
        dummy.setEnd(ZonedDateTime.of(2017, 2, 2, 2, 2, 2, 2, ZoneId.systemDefault()));
        dummy.setRating(new BigDecimal(9.5));
        dummy.setSubjects(Arrays.asList(TutorSubject.COMPSCI, TutorSubject.MATH, TutorSubject.IT));
        dummy.setAvailable(CalendarUtils.isAvailable(ZonedDateTime.of(2017, 1, 5, 1, 1, 1, 1, ZoneId.systemDefault()), dummy));
        log.info("{}", dummy);
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(dummy);

        return tutors;
    }

    public String insertTutor(Tutor tutor){
        JpaTutor jpaTutor = new JpaTutor();
        jpaTutor.setFirstName(tutor.getFirstName());
        jpaTutor.setLastName(tutor.getLastName());
        jpaTutor.setRating(tutor.getRating());
        jpaTutor.setNumOfRatings(tutor.getRating() != null ? 1 : 0);
        tutorRepository.save(jpaTutor); //assumes that this tutor doesn't exist yet. Can yield duplicates

        return String.format("Successfully saved %s, %s", tutor.getLastName(), tutor.getFirstName());
    }

    public String updateRating(String tutorId, BigDecimal rating){
        JpaTutor tutor = tutorRepository.findOne(tutorId);
        // do math to get the new rating.
        Float newRating = tutor.getRating().floatValue();
        Integer count = tutor.getNumOfRatings();
        newRating *= count; // derive old sum.
        newRating += rating.floatValue(); // calculate new sum.
        tutor.setNumOfRatings(++count);
        tutor.setRating(new BigDecimal(newRating / count));
        tutorRepository.save(tutor);

        return String.format("Tutor:%s has an overall rating of %f", tutorId, newRating);
    }
}
