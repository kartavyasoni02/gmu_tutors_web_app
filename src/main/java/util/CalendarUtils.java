package util;

import org.joda.time.DateTime;
import transfer.dto.Tutor;

/**
 * Created by Andrew on 4/21/2017.
 */
public class CalendarUtils {
    public static boolean isAvailable(DateTime currentTime, Tutor tutor){
        return currentTime.isBefore(tutor.getEnd()) && currentTime.isAfter(tutor.getStart());
    }
}
