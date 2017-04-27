package transfer.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Andrew on 4/22/2017.
 */
@Entity
@Table(name = "tutor")
public final class JPATutor implements Serializable {
    @Id
    @Column(name ="id_tutor")
    private Long tutorId;

    @Column(name = "name_first", nullable = false)
    private String firstName;

    @Column(name = "name_last", nullable = false)
    private String lastName;

    @Column(name = "amt_rating")
    private Double rating;

    @Column(name = "dttm_start")
    private Date startTime;

    @Column(name = "dttm_end")
    private Date endTime;

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
