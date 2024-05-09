package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

import java.util.ArrayList;

public class Use implements Command {

    /**
     * The execute method of the Use class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        if (!(game.getFocusedPerson() instanceof Student student)) {
            throw new IllegalStateException("Focused person is not a student.");
        }

        Item item = student.getItem(args[1].split("#")[1]);

        try {
            student.use(item);
            System.out.println("Item " + item + " used by Student#" + student.getName());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
