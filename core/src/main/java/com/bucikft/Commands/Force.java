package com.bucikft.Commands;

import com.bucikft.Game;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;
import com.bucikft.Room;


public class Force implements Command {

    /**
     * The execute method of the Force class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        String[] n = args[2].split("#");

        switch (args[1]) {
            case "move" -> {
                Person person = null;
                String personType = "person";

                switch (n[0]) {
                    case "St" -> {
                        person = game.getStudent(n[1]);
                        personType = "student";
                    }
                    case "Pr" -> {
                        person = game.getProfessor(n[1]);
                        personType = "professor";
                    }
                    case "Cl" -> {
                        person = game.getCleaner(n[1]);
                        personType = "cleaner";
                    }
                }

                if (person == null)
                    throw new IllegalStateException("No " + personType + " found with the given ID.");

                Room room = game.getMap().getRoom(args[3]);
                if (room == null)
                    throw new IllegalStateException("No room found with the given id: " + args[3]);

                move(person, room);
            }
            case "pickup" -> {
                if (n[0].equals("Pr")) {
                    Professor professor = game.getProfessor(n[1]);

                    if (professor == null)
                        throw new IllegalStateException("No professor found with the given ID: " + n[1]);

                    Room currentRoom = professor.getCurrentRoom();
                    String itemID = args[3];
                    Item item = currentRoom.getItem(itemID);

                    if (item == null)
                        throw new IllegalStateException("No item found in the room with the given ID: " + itemID);

                    currentRoom.getItemList().remove(item);
                    professor.getInventory().add(item);
                }
            }
            case "kill" -> {
                if (n[0].equals("Pr")) {
                    Professor professor = game.getProfessor(n[1]);
                    Student student = game.getStudent(args[3].split("#")[1]);

                    if (professor != null && student != null) {
                        try {
                            professor.setKillsLeft(professor.getKillsLeft() + 1);
                            professor.killStudent(student);
                            System.out.println("Forcekill from Professor" + professor.getName() + " to " + student.getName());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (professor == null) {
                        throw new IllegalStateException("No professor found with the given ID.");
                    } else {
                        throw new IllegalStateException("No student found with the given ID.");
                    }
                }
            }
            case "air" -> {
                if (n[0].equals("Cl")) {
                    Cleaner cleaner = game.getCleaner(n[1]);

                    if (cleaner != null) {
                        Room room = cleaner.getCurrentRoom();

                        room.setGassed(false);
                        System.out.println("Force air from Cleaner#" + cleaner + " to Room#" + room + ".");
                    } else {
                        throw new IllegalStateException("No cleaner found with the given ID.");
                    }
                }
            }
            case "gas" -> {
                Room room = game.getMap().getRoom(args[2]);

                room.setGassed(true);
                System.out.println("Force gassed room Room#" + room + ".");
            }
        }
    }

    private static void move(Person person, Room room)
    {
        person.getCurrentRoom().getPersonList().remove(person);
        person.setCurrentRoom(room);
        room.getPersonList().add(person);
        System.out.println(person + " moved to Room#" + person.getCurrentRoom());
    }

}