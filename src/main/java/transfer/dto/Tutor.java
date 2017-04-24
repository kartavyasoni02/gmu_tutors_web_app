package transfer.dto;

import org.joda.time.DateTime;
import util.TutorSubject;

import java.util.List;

/**
 * Created by Andrew on 4/21/2017.
 *
 * Tutor object that contains basic data on a tutor.
 */
public class Tutor {
    private String firstName;
    private String lastName;
    private DateTime start;
    private DateTime end;
    private Double rating; //average of all ratings. Range: 0-10
    private List<TutorSubject> subjects;
    private List<Location> locations;
    private boolean available;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<TutorSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TutorSubject> subjects) {
        this.subjects = subjects;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * UI friendly formatted full name.
     * LastName, FirstName
     * @return
     */
    public String getFullName(){
        return String.format("%s, %s", getLastName(), getFirstName());
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", rating=" + rating +
                ", subjects=" + subjects +
                ", locations=" + locations +
                ", available=" + available +
                '}';
    }
}
