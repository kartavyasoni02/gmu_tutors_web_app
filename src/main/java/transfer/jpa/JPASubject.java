package transfer.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrew on 4/22/2017.
 */
@Entity
@Table(name="subject")
public class JPASubject implements Serializable{

    @Column(name="id_subject", nullable = false)
    private Long subjectId;

    @Column(name="cd_subject", nullable = false)
    private String subjectDescription;

    @Column(name="id_tutor")
    private Long tutorId;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
}
