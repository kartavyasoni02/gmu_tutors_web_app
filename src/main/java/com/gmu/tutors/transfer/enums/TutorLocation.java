package com.gmu.tutors.transfer.enums;

/**
 * Created by Andrew on 4/23/2017.
 */
public enum TutorLocation {
    Fenwick("Fenwick Library"),
    JC("Johnson Center"),
    Engineering("Engineering Building"),
    Innovation("Innovation Hall"),
    Exploratory("Exploratory Hall"),
    UserDefined("User Defined");

    private final String description;

    TutorLocation(String s) {
        this.description = s;
    }

    public static TutorLocation fromDescription(String description){
        for (TutorLocation location : values()){
            if (location.description.equals(description)){
                return location;
            }
        }
        // else it is a user defined location.
        return UserDefined;
    }
}
