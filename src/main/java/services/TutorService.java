package services;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.TutorRepository;
import transfer.dto.Tutor;
import transfer.collections.MongoTutor;
import util.CalendarUtils;
import transfer.enums.TutorSubject;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Andrew on 4/21/2017.
 */
@Transactional
@Service
public class TutorService {
    private Logger log = LoggerFactory.getLogger(TutorService.class);

    @Autowired(required = false)
    TutorRepository tutorRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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
        tutorRepository.save(mongoTutor);

        return String.format("Successfully saved %s", tutor.getFullName());
    }
}
