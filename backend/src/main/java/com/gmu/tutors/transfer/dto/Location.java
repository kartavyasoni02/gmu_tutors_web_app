package com.gmu.tutors.transfer.dto;

import com.gmu.tutors.transfer.enums.TutorLocation;

import javax.validation.constraints.NotNull;

/**
 * Created by Andrew on 4/23/2017.
 *
 * wrapper that contains a LocationEnum obj and it's description.
 * note: UserDefined locations should not have their description() value used here.
 */
public class Location {
    private TutorLocation locationValue;
    private String description;

    public Location(){}

    // UserDefined TutorLocation value should not, and can not be used with this constructor.
    public Location(@NotNull TutorLocation locationValue){
        if (locationValue == TutorLocation.UserDefined)
            throw new IllegalArgumentException("UserDefined location requires a separate string description");
        this.locationValue = locationValue;
        this.description = locationValue.description();
    }

    // Any enum value for TutorLocation can be used here.
    // Description overwrites the default one. If description is null OR empty, use the enum description.
    public Location(@NotNull TutorLocation locationValue, String description) {
        this.locationValue = locationValue;
        if (description == null || description.trim().isEmpty()){
            this.description = locationValue.description();
        }
        else {
            this.description = description;
        }
    }

    public TutorLocation getLocationValue() {
        return locationValue;
    }

    public String getDescription() {
        return description;
    }

    /**
     * toString() should return the description of the location. For TutorLocation objects that are
     * not UserDefined, the description should match up with the description of the enum value.
     * @return
     */
    @Override
    public String toString() {
        return description;
    }
}
