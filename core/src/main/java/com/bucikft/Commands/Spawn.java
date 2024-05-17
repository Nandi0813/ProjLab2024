package com.bucikft.Commands;

import com.bucikft.Game;
import com.bucikft.Utils.IDmaker;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Professor;
import com.bucikft.Room;

public class Spawn implements Command {

    /**
     * The execute method of the Spawn class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (!game.getDebugMode()) {
            throw new IllegalArgumentException("debug mode not ON");
        }

        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        Room room = game.getFocusedPerson().getCurrentRoom();
        Item item = null;

        switch (args[1]) {
            case "DKC":
                item = new DKC(IDmaker.makeID(), false);
                break;
            case "EnergyDrink":
                item = new EnergyDrink(IDmaker.makeID(), false);
                break;
            case "Hammer":
                item = new Hammer(IDmaker.makeID(), false);
                break;
            case "HolyCup":
                item = new HolyCup(IDmaker.makeID(), false);
                break;
            case "Mask":
                item = new Mask(IDmaker.makeID(), false);
                break;
            case "SlipStick":
                item = new SlipStick(IDmaker.makeID(), false);
                break;
            case "Transistor":
                item = new Transistor(IDmaker.makeID(), false);
                break;
            case "TVSZ":
                item = new TVSZ(IDmaker.makeID(), false);
                break;
            case "WetRag":
                item = new WetRag(IDmaker.makeID(), false);
                break;
            case "Zyn":
                item = new Zyn(IDmaker.makeID(), false);
                break;
            case "AirFreshener":
                item = new AirFreshener(IDmaker.makeID(), false);
                break;
            case "Professor":
                Professor professor = new Professor(IDmaker.makeID());

                game.getProfessors().add(professor);
                room.getPersonList().add(professor);
                professor.setCurrentRoom(room);

                System.out.println("Professor spawned in Room#" + room + ".");
                return;
        }

        if (item != null) {
            room.getItemList().add(item);
            room.setItemCapacity(room.getItemCapacity() + 1);
            System.out.println(args[1] + " spawned in Room#" + room + ".");
        }
    }
}
