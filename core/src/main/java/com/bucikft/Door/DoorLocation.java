package com.bucikft.Door;

/**
 * The enum Door location.
 */
public enum DoorLocation {

    /**
     * Top door location.
     */
    TOP,
    /**
     * Right door location.
     */
    RIGHT,
    /**
     * Bottom door location.
     */
    BOTTOM,
    /**
     * Left door location.
     */
    LEFT;

    /**
     * Gets opposite.
     *
     * @param location the location
     * @return the opposite
     */
    public static DoorLocation getOpposite(DoorLocation location) {
        return switch (location) {
            case TOP -> BOTTOM;
            case RIGHT -> LEFT;
            case BOTTOM -> TOP;
            case LEFT -> RIGHT;
        };
    }

}
