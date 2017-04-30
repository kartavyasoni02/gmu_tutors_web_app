package transfer.dto;

import transfer.enums.TutorLocation;

/**
 * Created by Andrew on 4/23/2017.
 *
 * wrapper that contains a LocationEnum obj and it's description.
 *
 * user defined locations will not have their description here
 */
public class Location {
    private TutorLocation locationValue;
    private String description;

    public TutorLocation getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(TutorLocation locationValue) {
        this.locationValue = locationValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationValue=" + locationValue +
                ", description='" + description + '\'' +
                '}';
    }
}
