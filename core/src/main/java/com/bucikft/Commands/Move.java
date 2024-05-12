package com.bucikft.Commands;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Game;
import com.bucikft.Person.Student;
import com.bucikft.Room;

public class Move implements Command {

    /**
     * The execute method of the Move class.
     * @param game The game object.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        }

        try {
            if (!(game.getFocusedPerson() instanceof Student student)) {
                throw new IllegalStateException("The focused person is not a student.");
            }

            if (student.getMovesLeft() == 0) {
                throw new IllegalStateException("No moves left.");
            }

            Room room = student.getCurrentRoom();
            Room roomTo = room.getRoom(DoorLocation.valueOf(args[1]));

            if (roomTo == null) {
                throw new IllegalStateException("No room in that direction");
            }

            student.move(roomTo, false);
            System.out.println("Student#" + student.getName() + " moved to " + student.getCurrentRoom() + ".");
        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid direction.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
