package com.gmu.tutors.controllers;


import com.gmu.tutors.services.TutorService;
import com.gmu.tutors.transfer.dto.Tutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest
@EnableSpringDataWebSupport
public class TutorControllerTest {
    private static final Logger log = LoggerFactory.getLogger(TutorControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TutorService tutorService;

    @Test
    public void foo() {
        assert true;
    }

    @Test
    public void allEndpointIsOperational() {
        Tutor t1 = new Tutor();
        Tutor t2 = new Tutor();
        Tutor t3 = new Tutor();
        List<Tutor>  tutors = Arrays.asList(t1, t2, t3);
        
    }
}
