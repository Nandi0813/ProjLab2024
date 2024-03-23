package com.bucikft.Items;
import com.bucikft.Person.Student;


public class DKC extends Item {

    public void effect(Student user) {
        if(!user.getCurrentRoom().isGassed()){
            if(!this.getBroken()) {
                user.getCurrentRoom().setIsGassed(true);
                this.setBroken(true);
            }
            else{
                System.out.println("A DKC már el lett használva.");
            }
        } else{
            System.out.println("A szoba nem volt gázzal teli!");
        }
    }
}
