package com.gmu.tutors.util;

import org.joda.time.DateTime;
import com.gmu.tutors.transfer.dto.Tutor;

/**
 * Created by Andrew on 4/21/2017.
 */
public class CalendarUtils {
    public static boolean isAvailable(DateTime currentTime, Tutor tutor){
        return currentTime.isBefore(new DateTime(tutor.getEnd())) && currentTime.isAfter(new DateTime(tutor.getStart()));
    }
}
