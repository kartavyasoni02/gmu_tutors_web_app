package transfer.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Andrew on 4/22/2017.
 */
@Entity
@Table(name = "tutor")
public final class JPATutor implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id_tutor")
    private Long idTutor;

    @Column(name = "text_name_first", nullable = false)
    private String textNameFirst;

    @Column(name = "text_name_last", nullable = false)
    private String textNameLast;

    @Column(name = "amt_rating")
    private BigDecimal amtRating;

    @Column(name = "dttm_start")
    private Date dttmStart;

    @Column(name = "dttm_end")
    private Date dttmEnd;

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getTextNameFirst() {
        return textNameFirst;
    }

    public void setTextNameFirst(String textNameFirst) {
        this.textNameFirst = textNameFirst;
    }

    public String getTextNameLast() {
        return textNameLast;
    }

    public void setTextNameLast(String textNameLast) {
        this.textNameLast = textNameLast;
    }

    public BigDecimal getAmtRating() {
        return amtRating;
    }

    public void setAmtRating(BigDecimal amtRating) {
        this.amtRating = amtRating;
    }

    public Date getDttmStart() {
        return dttmStart;
    }

    public void setDttmStart(Date dttmStart) {
        this.dttmStart = dttmStart;
    }

    public Date getDttmEnd() {
        return dttmEnd;
    }

    public void setDttmEnd(Date dttmEnd) {
        this.dttmEnd = dttmEnd;
    }
}
