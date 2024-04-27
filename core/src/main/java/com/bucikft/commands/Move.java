package com.bucikft.commands;
import com.bucikft.Game;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/*public class Move implements Command {
    @Override
     void execute(Game game, String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("invalid number of arguments");
        try {
            DoorLocation location = DoorLocation.valueOf(args[1].toUpperCase());
            Student student = (Student) game.getFocusedPerson();
            Room current = student.getCurrentRoom();
            Room next = current.getRoom(location);
            if (next == null) {
                System.out.println("no door in that direction");
                return;
            }
            student.move(next);
            System.out.println("student "+ student +" moved to room "+ next);
        } catch (IllegalArgumentException e) {
            System.out.println("invalid direction");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
    */
