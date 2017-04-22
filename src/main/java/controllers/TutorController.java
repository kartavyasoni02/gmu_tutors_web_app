package controllers;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import services.TutorService;
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

    @RequestMapping(value="/tutors/all")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Fetches all of the tutors currently in the system.")
    @ExceptionHandler(SpringException.class)
    public List<Tutor> fetchAllTutors(){
        return tutorService.getAllTutors();
    }

    @RequestMapping(value="/tutors/available")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value="Fetches all tutors available between two date times")
    @ExceptionHandler(SpringException.class)
    public List<Tutor> fetchAvailableTutors(@RequestBody Date start,
                                            @RequestBody Date end){
        return tutorService.getAvailableTutors(start, end);
    }
}
