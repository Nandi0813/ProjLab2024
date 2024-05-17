package com.bucikft.Commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.Items.Transistor;

public class Join implements Command {

    /**
     * The execute method of the Join class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        }

        if (!(game.getFocusedPerson() instanceof Student student)) {
            throw new IllegalArgumentException("Invalid person type.");
        }

        Item first = student.getCurrentRoom().getItem(args[1].split("#")[1]);
        Item second = student.getCurrentRoom().getItem(args[2].split("#")[1]);

        if (first == null || second == null) {
            throw new IllegalArgumentException("Invalid item IDs.");
        }

        if (first instanceof Transistor t1 && second instanceof Transistor t2) {
            student.join(t1, t2);
            System.out.println("Transistor " + first + " joined to transistor " + second + ".");
        }
        else {
            throw new IllegalArgumentException("Invalid item types.");
        }
    }
}

