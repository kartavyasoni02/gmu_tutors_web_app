package services;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SubjectRepository;
import repository.TutorRepository;
import transfer.dto.Tutor;
import transfer.jpa.JPASubject;
import transfer.jpa.JPATutor;
import util.CalendarUtils;
import util.TutorSubject;

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
    @Autowired
    SubjectRepository subjectRepository;

    public List<Tutor> getAllTutors(){
        // dummy
        Tutor dummy = new Tutor();
        dummy.setFirstName("Andrew");
        dummy.setLastName("Huynh");
        dummy.setStart(new DateTime());
        dummy.setEnd(new DateTime().withYear(2018).withMonthOfYear(4).withDayOfMonth(20));
        List<Double> ratings = Arrays.asList(3.0,6.0,7.5,3.5,8.0,9.5,10.0,10.0,10.0,9.0);
        dummy.setRating(getAverageRating(ratings));
        dummy.setSubjects(Arrays.asList(TutorSubject.COMPSCI, TutorSubject.MATH, TutorSubject.IT));
        dummy.setAvailable(CalendarUtils.isAvailable(new DateTime(), dummy));
        log.info("{}", dummy);
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(dummy);

        return tutors;
    }

    private BigDecimal getAverageRating(List<Double> ratings){
        Double result = 0.0;
        for (Double rating : ratings){
            result += rating;
        }
        if (ratings.size() == 0){
            return null; // can't divide by 0, and shouldn't give any rating if no ratings exist.
        }
        else {
            result /= ratings.size();
            return new BigDecimal(result);
        }
    }
    private JPASubject findByTutorId(List<JPASubject> subjects, Long tutorId){
        for (JPASubject subject : subjects){
            if (subject.getIdTutor().equals(tutorId)){
                return subject;
            }
        }
        return null;
    }
    private Tutor mapFromTutors(List<JPATutor> tutors, Long tutorId){
        for (JPATutor tutor : tutors){
            if (tutor.getIdTutor().equals(tutorId)){
                return mapFromJPA(tutor);
            }
        }
        return null;
    }

    private Tutor mapFromJPA(JPATutor jpaTutor){
        Tutor tutor = new Tutor();
        tutor.setFirstName(jpaTutor.getTextNameFirst());
        tutor.setLastName(jpaTutor.getTextNameLast());
        tutor.setStart(new DateTime(jpaTutor.getDttmStart()));
        tutor.setEnd(new DateTime(jpaTutor.getDttmEnd()));
        tutor.setRating(jpaTutor.getAmtRating());
        //tutor.setSubjects();

        return tutor;
    }

    public String addTutor(Tutor tutor){
        JPATutor jpaTutor = new JPATutor();
        jpaTutor.setTextNameFirst(tutor.getFirstName());
        jpaTutor.setTextNameLast(tutor.getLastName());
        jpaTutor.setAmtRating(tutor.getRating());
        jpaTutor.setDttmStart(tutor.getStart().toDate());
        jpaTutor.setDttmEnd(tutor.getEnd().toDate());

        tutorRepository.save(jpaTutor);

        return String.format("Tutor: '%s' saved successfully.", tutor.getFullName());
    }
}
