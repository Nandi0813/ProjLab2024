package com.bucikft.commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
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
                            System.out.println(p + " moved to " + p.getCurrentRoom());
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
                            System.out.println(p + "moved to Room#" + p.getCurrentRoom() );
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
                            System.out.println(p + " moved to Room#" + p.getCurrentRoom());

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
                n = args[2].split("#");
                String[] victim = args[3].split("#");
                if (n[0].equals("Pr")) {
                    boolean found = false;
                    for (Professor p : game.getProfessors()) {
                        if (p.getName().equals(n[1])) {
                            for(Student v : game.getStudents()) {
                                if (v.getName().equals(victim[1])) {
                                    try {
                                        p.setKillsLeft(p.getKillsLeft()+1);
                                        p.killStudent(v);
                                        System.out.println("forcekill from Professor" + p.getName() + " to " + v.getName());
                                    } catch (IllegalStateException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No professor found with the given ID.");
                }
                break;
            case "air":
                String[] cleaner = args[2].split("#");
                if (cleaner[0].equals("Cl")) {
                    boolean found = false;
                    for (Cleaner p : game.getCleaners()) {
                        if (p.getName().equals(cleaner[1])) {
                            p.getCurrentRoom().setGassed(false);
                            System.out.println("forceair from " + p + " cleaner");
                            found = true;
                        }
                    }
                if (!found) System.out.println("No cleaner found with the given ID.");
            }
            break;
            case "gas":
                for (Room r : game.getMap().getRoomList()) {
                    if (r.getID().equals(args[2])) {
                        r.setGassed(true);
                        System.out.println("forcefully gassed room Room#" + r);
                    }
                }
                break;
            }
        }
}