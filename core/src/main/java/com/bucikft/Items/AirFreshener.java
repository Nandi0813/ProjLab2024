package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/*
 * A single-use item. It neutralizes the gas effect when placed in a gassed room.
 */
public class AirFreshener extends Item {

    /**
     * The constructor of the AirFreshener class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public AirFreshener(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
    }

    /**
     * Applies the effect of the air freshener item on the room.
     *
     * @param user The student who uses the item.
     */
    @Override
    public void effect(Student user) throws IllegalStateException{
        if(user.getCurrentRoom().isGassed()){
            user.getCurrentRoom().setGassed(false);
            this.setBroken(true);
        }
        else{
            throw new IllegalStateException("The room is not filled with gas.");
        }

    }

}
