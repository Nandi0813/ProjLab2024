package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/*
 * A single-use item. It neutralizes the gas effect when placed in a gassed room.
 */
public class AirFreshener extends Item {
    public AirFreshener(String ID) {
        super(ID);
    }

    /**
     * Applies the effect of the air freshener item on the room.
     *
     * @param user The student who uses the item.
     */
    @Override
    public void effect(Student user) {

    }

}
