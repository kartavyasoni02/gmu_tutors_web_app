package com.gmu.tutors.services;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmu.tutors.repository.TutorRepository;
import com.gmu.tutors.transfer.dto.Tutor;
import com.gmu.tutors.transfer.model.MongoTutor;
import com.gmu.tutors.util.CalendarUtils;
import com.gmu.tutors.transfer.enums.TutorSubject;

import java.math.BigDecimal;
import java.util.*;

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
        dummy.setStart(new DateTime());
        dummy.setEnd(new DateTime().withYear(2018).withMonthOfYear(4).withDayOfMonth(20));
        dummy.setRating(new BigDecimal(9.5));
        dummy.setSubjects(Arrays.asList(TutorSubject.COMPSCI, TutorSubject.MATH, TutorSubject.IT));
        dummy.setAvailable(CalendarUtils.isAvailable(new DateTime(), dummy));
        log.info("{}", dummy);
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(dummy);

        return tutors;
    }

    public String insertTutor(Tutor tutor){
        // use MongoDB integration
        MongoTutor mongoTutor = new MongoTutor();
        mongoTutor.setFirstName(tutor.getFirstName());
        mongoTutor.setLastName(tutor.getLastName());
        tutorRepository.insert(mongoTutor); //assumes that this tutor doesn't exist yet. Can yield duplicates

        return String.format("Successfully saved %s", tutor.getFullName());
    }

    public String updateRating(String tutorId, BigDecimal rating){
        MongoTutor tutor = tutorRepository.findOne(tutorId);
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
