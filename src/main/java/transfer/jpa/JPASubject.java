package transfer.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrew on 4/22/2017.
 */
@Entity
@Table(name="subject")
public class JPASubject implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="id_subject", nullable = false)
    private Long idSubject;

    @Column(name="cd_subject", nullable = false)
    private String cdSubject;

    @Column(name="id_tutor")
    private Long idTutor;

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public String getCdSubject() {
        return cdSubject;
    }

    public void setCdSubject(String cdSubject) {
        this.cdSubject = cdSubject;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }
}
