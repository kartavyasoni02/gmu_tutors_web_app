package controllers;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.TutorService;
import transfer.dto.DateRange;
import transfer.dto.Tutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 4/21/2017.
 */
@Controller
public class TutorController {
    @Autowired
    TutorService tutorService;

    private Logger log = LoggerFactory.getLogger(TutorController.class);

    @RequestMapping(value="/tutors/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Fetches all of the tutors currently in the system.")
    public List<Tutor> fetchAllTutors(){
        return tutorService.getAllTutors();
    }

    @RequestMapping(value="/tutors/available", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Fetches all tutors available between two date times")
    public List<Tutor> fetchAvailableTutors(@RequestBody DateRange range){
        return tutorService.getAvailableTutors(range.getBegin(), range.getEnd());
    }

    @RequestMapping(value="/tutors/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Persists a tutor from the frotn end into the database")
    public String addTutor(@RequestBody Tutor tutor){
        return tutorService.addTutor(tutor);
    }
}
