package com.gmu.tutors.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gmu.tutors.services.TutorService;
import com.gmu.tutors.transfer.dto.Tutor;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Andrew on 4/21/2017.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/tutors", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Tutor Controller", description = "Operations on tutor objects")
public class TutorController {

    @Autowired
    TutorService tutorService;

    private Logger log = LoggerFactory.getLogger(TutorController.class);

    @GetMapping("/all")
    @ApiOperation(value="Fetches all of the tutors currently in the system.")
    public List<Tutor> fetchAllTutors(HttpServletRequest servletRequest) throws IOException{
        log.info("GET request: /api/tutors/all");
        return tutorService.getAllTutors();
    }

    @PutMapping("/insert")
    @ApiOperation(value="Persists a new tutor from the frotn end into the database")
    public String addTutor(@RequestBody Tutor tutor,
                                     HttpServletRequest servletRequest) throws IOException{
        log.info("PUT request: /api/tutors/insert with value: {}", tutor);
        return new tutorService.insertTutor(tutor);
    }

    @PatchMapping("/rating/{id}")
    @ApiOperation(value = "Adds a rating to an existing Tutor")
    public String updateRating(@RequestBody BigDecimal rating,
                               @PathVariable String id,
                               HttpServletRequest servletRequest) throws IOException{
        log.info("PATCH request: /api/tutors/rating/{id} with value: {}", id);
        return tutorService.updateRating(id, rating);
    }
}
