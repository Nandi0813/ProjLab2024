package com.bucikft.Door;

public enum DoorLocation {
    TOP, RIGHT, BOTTOM, LEFT;
    public static DoorLocation getOpposite(DoorLocation location) {
        switch (location) {
            case TOP:
                return BOTTOM;
            case RIGHT:
                return LEFT;
            case BOTTOM:
                return TOP;
            case LEFT:
                return RIGHT;
        }
        return null;
    }
}
