package com.gmu.tutors.transfer.dto;

import com.gmu.tutors.transfer.enums.TutorLocation;
import org.apache.commons.lang3.StringUtils;

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

    /**
     * 1 argument constructor for Location
     * @param locationValue a TutorLocation, excluding <code>TutorLocation.UserDefined</code>
     * @throws IllegalArgumentException if argument is <code>TutorLocation.UserDefined</code>
     */
    public Location(@NotNull TutorLocation locationValue) throws IllegalArgumentException {
        if (locationValue == TutorLocation.UserDefined)
            throw new IllegalArgumentException("UserDefined location requires a separate string description");
        this.locationValue = locationValue;
        this.description = locationValue.description();
    }

    /**
     * 2 argument constructor for Location
     * @param locationValue any TutorLocation value
     * @param description a String description that overrides the default
     */
    public Location(@NotNull TutorLocation locationValue, String description) {
        this.locationValue = locationValue;
        if (StringUtils.isBlank(description)){
            this.description = locationValue.description();
        }
        else {
            this.description = description;
        }
    }

    /**
     * Gets the TutorLocation value for this Location
     * @return an enum value of a TutorLocation
     */
    public TutorLocation getLocationValue() {
        return locationValue;
    }

    /**
     * Gets the description of this Location
     * @return either the <code>description()</code> of the TutorLocation, or an overridden value
     */
    public String getDescription() {
        return description;
    }

    /**
     * toString() should return the description of the location. For TutorLocation objects that are
     * not UserDefined, the description should match up with the description of the enum value.
     * @return this Location's <code>description</code> field
     */
    @Override
    public String toString() {
        return description;
    }
}
