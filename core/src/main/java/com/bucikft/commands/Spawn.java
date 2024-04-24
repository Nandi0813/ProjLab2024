package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.IDmaker;
import com.bucikft.Items.*;
import com.bucikft.Person.Professor;
import com.bucikft.Room;

public class Spawn implements Command {
    IDmaker idMaker = new IDmaker();
    @Override
    public void execute(Game game, String[] args) {
        if (!game.getDebugMode()) throw new IllegalArgumentException("debug mode not ON");
        if (args.length != 2) throw new IllegalArgumentException("Invalid number of arguments");
        Room room = game.getFocusedPerson().getCurrentRoom();
        switch(args[1]) {
            case "DKC":
                DKC dkc = new DKC(idMaker.makeID(), false);
                room.getItemsList().add(dkc);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("DKC spawned in room " + room);
                break;
            case "EnergyDrink":

                EnergyDrink eg = new EnergyDrink(idMaker.makeID(), false);
                room.getItemsList().add(eg);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("EnergyDrink spawned in room " + room);
                break;
            case "Hammer":
                Hammer h = new Hammer(idMaker.makeID(), false);
                room.getItemsList().add(h);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("Hammer spawned in room " + room);
                break;
            case "HolyCup":
                HolyCup c = new HolyCup(idMaker.makeID(), false);
                room.getItemsList().add(c);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("HolyCup spawned in room " + room);
                break;
            case "Mask":
                Mask m = new Mask(idMaker.makeID(), false);
                room.getItemsList().add(m);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("Mask spawned in room " + room);
                break;
            case "SlipStick":
                SlipStick s = new SlipStick(idMaker.makeID(), false);
                room.getItemsList().add(s);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("SlipStick spawned in room " + room);
                break;
            case "Transistor":
                Transistor t = new Transistor(idMaker.makeID(), false);
                room.getItemsList().add(t);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("Transistor spawned in room " + room);
                break;
            case "TVSZ":
                TVSZ tvsz = new TVSZ(idMaker.makeID(), false);
                room.getItemsList().add(tvsz);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("TVSZ spawned in room " + room);
                break;
            case "WetRag":
                WetRag wr = new WetRag(idMaker.makeID(), false);
                room.getItemsList().add(wr);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("WetRag spawned in room " + room);
                break;
            case "Zyn":
                Zyn z = new Zyn(idMaker.makeID(), false);
                room.getItemsList().add(z);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("Zyn spawned in room " + room);
                break;
            case "AirFreshener":
                AirFreshener af = new AirFreshener(idMaker.makeID(), false);
                room.getItemsList().add(af);
                room.setItemCapacity(room.getItemCapacity() + 1);
                System.out.println("AirFreshener spawned in room " + room);
                break;
            case "Professor":
                Professor professor = new Professor(idMaker.makeID());
                game.getProfessors().add(professor);
                room.getPersonList().add(professor);
                professor.setCurrentRoom(room);
                System.out.println("Professor spawned in room " + room);
                break;
        }
    }
}
