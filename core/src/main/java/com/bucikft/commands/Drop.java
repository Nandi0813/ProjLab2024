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
        if (args.length != 2) throw new IllegalArgumentException("invalid number of arguments");
        Student student = (Student) game.getFocusedPerson();
        String[] item = args[1].split("#");
        for (Item i : student.getItemList()) {
            if (i.getID().equals(item[1])) {
                student.drop(i);
                System.out.println("item "+ i +" dropped by student "+ student);
                return;
            }
        }
    }
}
