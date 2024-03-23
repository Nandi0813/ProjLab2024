package com.bucikft.Items;
import com.bucikft.Person.Student;

public abstract class Item {

    private boolean broken = false;

    public boolean getBroken() {
        return broken;
    }
    public void setBroken(boolean newBroken) {
        broken = newBroken;
    }
    public abstract void effect(Student user);
}
