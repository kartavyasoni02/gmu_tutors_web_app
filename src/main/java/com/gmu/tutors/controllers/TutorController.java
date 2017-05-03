package com.gmu.tutors.controllers;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gmu.tutors.services.TutorService;
import com.gmu.tutors.transfer.dto.Tutor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Andrew on 4/21/2017.
 */
@Controller
@RequestMapping(value = "/api/tutors")
public class TutorController {

    @Autowired
    TutorService tutorService;

    private Logger log = LoggerFactory.getLogger(TutorController.class);

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Fetches all of the tutors currently in the system.")
    public List<Tutor> fetchAllTutors(){
        log.info("GET request: /api/tutors/all");
        return tutorService.getAllTutors();
    }

    @RequestMapping(value="/insert", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Persists a new tutor from the frotn end into the database")
    public String addTutor(@RequestBody Tutor tutor){
        log.info("PUT request: /api/tutors/insert with value: {}", tutor);
        return tutorService.insertTutor(tutor);
    }

    @RequestMapping(value="/rating/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(value= HttpStatus.OK)
    @ApiOperation(value = "Adds a rating to an existing Tutor")
    public String updateRating(@RequestBody BigDecimal rating, @RequestParam String id){
        log.info("PATCH request: /api/tutors/rating/{id} with value: {}", id);
        return tutorService.updateRating(id, rating);
    }
}
