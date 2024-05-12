package com.bucikft.Commands;

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
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        Person person = game.getFocusedPerson();
        Item item = person.getCurrentRoom().getItem(args[1]); // pickup Name like pickup AirFreshener

        if (item == null) {
            throw new IllegalStateException("Item not found.");
        }

        try {
            person.pickUp(item);
            System.out.println("Item " + item + " picked up by Student#" + person.getName() + ".");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}



