package com.bucikft.Door;

public enum DoorLocation {

    TOP,
    RIGHT,
    BOTTOM,
    LEFT;

    public static DoorLocation getOpposite(DoorLocation location) {
        return switch (location) {
            case TOP -> BOTTOM;
            case RIGHT -> LEFT;
            case BOTTOM -> TOP;
            case LEFT -> RIGHT;
        };
    }

}
