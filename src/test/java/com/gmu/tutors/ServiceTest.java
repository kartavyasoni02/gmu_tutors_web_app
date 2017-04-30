package com.gmu.tutors;

import com.gmu.tutors.repository.TutorRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmu.tutors.transfer.model.MongoTutor;

/**
 * Created by Andrew on 4/22/2017.
 */
@Service
@Transactional
public class ServiceTest {
    private Logger log = LoggerFactory.getLogger(ServiceTest.class);

    @Autowired
    TutorRepository tutorRepository;

    @Test
    public void simpleTest(){
        MongoTutor mongoTutor = new MongoTutor();
        mongoTutor.setFirstName("Andrew");
        mongoTutor.setLastName("Huynh");
        tutorRepository.save(mongoTutor);
    }
}
