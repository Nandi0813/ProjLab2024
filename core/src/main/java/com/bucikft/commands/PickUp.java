package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;

public class PickUp implements Command {

    /**
     * The execute method of the PickUp class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Invalid number of arguments");

        Person person = game.getFocusedPerson();
        String[] item = args[1].split("#");
        if (item.length != 2) throw new IllegalArgumentException("Invalid item ID");
        for (Item i : person.getCurrentRoom().getItemsList()) {
            if (i.getID().equals(item[1])) {
                try {
                    person.pickUp(i);
                    System.out.println("item "+ i + " picked up by Student#" + person.getName());
                    return;
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Item not found");
    }
}



