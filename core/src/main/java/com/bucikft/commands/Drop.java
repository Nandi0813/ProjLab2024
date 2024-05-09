package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

public class Drop implements Command {

    /**
     * Drops an item from the student's inventory.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        }

        if (!(game.getFocusedPerson() instanceof Student student)) {
            throw new IllegalStateException("The focused person is not a student.");
        }

        Item item = student.getItem(args[1].split("#")[1]);

        if (item != null) {
            student.drop(item);
            System.out.println("Item " + item + " dropped by student " + student + ".");
        } else {
            System.out.println("Item: " + args[1] + " not found in student's inventory.");
        }
    }

}
