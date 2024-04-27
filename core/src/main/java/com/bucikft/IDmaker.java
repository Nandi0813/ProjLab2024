package com.bucikft;

public class IDmaker {
   private int id;
    public String makeID() {
        return Integer.toString(id++);
    }
}
