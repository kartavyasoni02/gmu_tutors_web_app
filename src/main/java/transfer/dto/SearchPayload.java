package transfer.dto;

import util.TutorSubject;

import java.util.List;

/**
 * Created by Andrew on 4/23/2017.
 */
public class SearchPayload {
    private List<TutorSubject> subjects;
    private DateRange dateRange;
    private List<Location> locations;
}
