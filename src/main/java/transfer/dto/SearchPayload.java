package transfer.dto;

import util.TutorSubject;

import java.util.List;

/**
 * Created by Andrew on 4/23/2017.
 *
 * DTO Payload for a web app search for a tutor.
 */
public class SearchPayload {
    private List<TutorSubject> subjects; // the user will select 1 or many subjects
    private DateRange dateRange; // the user must provide a date range - start and end date times
    private List<Location> locations; // the user will provide 0 or many locations they want to search for.
                                      // if the user provides no locations, then the query will include tutors from all


    public List<TutorSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TutorSubject> subjects) {
        this.subjects = subjects;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "SearchPayload{" +
                "subjects=" + subjects +
                ", dateRange=" + dateRange +
                ", locations=" + locations +
                '}';
    }
}
