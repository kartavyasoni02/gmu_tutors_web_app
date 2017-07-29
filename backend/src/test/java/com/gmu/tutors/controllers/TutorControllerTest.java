package com.gmu.tutors.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    public void fetchAllTutorsEndpointIsOperational()  throws Exception {
        Tutor t1 = new Tutor();
        Tutor t2 = new Tutor();
        Tutor t3 = new Tutor();
        List<Tutor>  tutors = Arrays.asList(t1, t2, t3);
        when(tutorService.getDummyTutorList()).thenReturn(tutors);

        this.mvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

        tutorService.getDummyTutorList().forEach(tutor -> log.debug("{}", tutor));
    }

    @Test
    public void insertTutorEndpointIsOperational() throws Exception {
        Tutor tutor = new Tutor();
        final String message = "This is a return value";
        when(tutorService.insertTutor(tutor)).thenReturn(message);

        this.mvc
                .perform(put("/api/insert")
                    .content(asJsonString(tutor))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(equalTo(message))));
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
