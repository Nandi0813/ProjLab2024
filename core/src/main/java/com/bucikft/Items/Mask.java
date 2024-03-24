package com.bucikft.Items;
import com.bucikft.Person.Student;

public class Mask extends Item{

    public void effect(Student user){
        // test if broken or user already masked
        if (this.getBroken()) throw new IllegalStateException("A Maszk már el lett használva");
        if (user.isMasked()) throw new IllegalStateException("A hallgató már maszkot visel");

        // put on mask
        user.setMasked(true);
        System.out.println("*A hallgató felvette a maszkot*");

        // break item
        this.setBroken(true);
    }
}
