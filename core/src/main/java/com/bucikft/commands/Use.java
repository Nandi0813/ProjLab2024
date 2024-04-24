package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

public class Use implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Invalid number of arguments");
        Student student = (Student) game.getFocusedPerson();
        String[] item = args[1].split("#");
        for (Item i : student.getItemList()) {
            if (i.getID().equals(item[1])) {
                student.use(i);
                System.out.println("item "+ i +" used by student "+ student);
                return;
            }
        }
    }
}
