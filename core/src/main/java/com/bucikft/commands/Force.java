package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;
import com.bucikft.Room;


import java.util.ArrayList;


public class Force implements Command {

    // Force move, pickup, kill, air, gas
    @Override
    public void execute(Game game, String[] args) {
        switch (args[1]) {
            case "move":
                String[] n = args[2].split("#");
                if (n[0].equals("St")) {
                    boolean found = false;
                    for (Person p : game.getStudents()) {
                        if (p.getName().equals(n[1])) {
                            Room current = p.getCurrentRoom();
                            p.setCurrentRoom(game.getMap().getRoomList().get(Integer.parseInt(args[3])));
                            current.getPersonList().remove(p);
                            p.getCurrentRoom().getPersonList().add(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No student found with the given ID.");
                } else if (n[0].equals("Pr")) {
                    boolean found = false;
                    for (Person p : game.getProfessors()) {
                        if (p.getName().equals(n[1])) {
                            Room current = p.getCurrentRoom();
                            p.setCurrentRoom(game.getMap().getRoomList().get(Integer.parseInt(args[3])));
                            current.getPersonList().remove(p);
                            p.getCurrentRoom().getPersonList().add(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No professor found with the given ID.");

                } else if (n[0].equals("Cl")) {
                    boolean found = false;
                    for (Person p : game.getCleaners()) {
                        if (p.getName().equals(n[1])) {
                            Room current = p.getCurrentRoom();
                            p.setCurrentRoom(game.getMap().getRoomList().get(Integer.parseInt(args[3])));
                            current.getPersonList().remove(p);
                            p.getCurrentRoom().getPersonList().add(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No cleaner found with the given ID.");
                }
                break;
            case "pickup":
                n = args[2].split("#");
                boolean itemFound = false;
                String[] itemname = args[3].split("#");
                if (n[0].equals("Pr")) {
                    boolean found = false;
                    for (Person p : game.getProfessors()) {
                        if (p.getName().equals(n[1])) {
                            for (Item i : new ArrayList<>(p.getCurrentRoom().getItemsList())) {
                                if (i.getID().equals(itemname[1])) {
                                    p.getInventory().add(i);
                                    p.getCurrentRoom().getItemsList().remove(i);
                                    itemFound = true;
                                }
                            }
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No professor found with the given ID.");
                    if (!itemFound) System.out.println("No item found in the room with the given ID");
                }
                break;
            case "kill":

                break;
            case "air":

                break;
            case "gas":

                break;
            }
        }

}