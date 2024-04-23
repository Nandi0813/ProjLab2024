package com.bucikft;

import java.util.ArrayList;

public class IDmaker {
    private ArrayList<Integer> ids = new ArrayList<>();
    public String makeID() {
        int id = (int) (Math.random() * 1000);
        while (ids.contains(id)) {
            id = (int) (Math.random() * 1000);
        }
        ids.add(id);
        return Integer.toString(id);
    }
}
