package com.gmu.tutors.util;

import com.gmu.tutors.transfer.dto.Tutor;

import java.time.ZonedDateTime;

public class CalendarUtils {
    public static boolean isAvailable(ZonedDateTime currentTime, Tutor tutor){
        return currentTime.isBefore(tutor.getEnd()) && currentTime.isAfter(tutor.getStart());
    }
}
