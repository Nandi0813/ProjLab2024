package com.bucikft.commands;

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
        if (args.length != 3) throw new IllegalArgumentException("Invalid number of arguments");

        Student student = (Student) game.getFocusedPerson();
        String[] t1 = args[1].split("#");
        String[] t2 = args[2].split("#");

        Transistor first = null;
        Transistor second = null;

        if (t1.length != 2 || t2.length != 2) throw new IllegalArgumentException("Invalid item ID");
        for (Item i : student.getCurrentRoom().getItemsList()) {
            if (i.getID().equals(t1[1])) {
                first = (Transistor) i;
            }
        }
        for (Item i : student.getInventory()) {
            if (i.getID().equals(t2[1])) {
                second = (Transistor) i;
            }
        }
        if(first != null && second != null) {
            student.join(second, first);
            System.out.println("transistor " + first + " joined to transistor " + second);
        }
        else
            throw new IllegalArgumentException("Failed connection.");
    }
}

