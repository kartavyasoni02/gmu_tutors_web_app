package transfer.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrew on 4/23/2017.
 */
@Entity
@Table(name = "location")
public class JPALocation implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_location", nullable = false)
    private Long locationId;

    @Column(name = "cd_location", nullable = false)
    private String cdLocation;

    @Column(name = "text_location_desc")
    private String textLocationDesc;

    @Column(name = "id_tutor")
    private Long idTutor;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getCdLocation() {
        return cdLocation;
    }

    public void setCdLocation(String cdLocation) {
        this.cdLocation = cdLocation;
    }

    public String getTextLocationDesc() {
        return textLocationDesc;
    }

    public void setTextLocationDesc(String textLocationDesc) {
        this.textLocationDesc = textLocationDesc;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }
}
