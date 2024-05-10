package com.bucikft.Commands;
import com.bucikft.Game;
import com.bucikft.Menu;
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

            if (student.getMovesLeft() <= 0) {
                throw new IllegalStateException("No moves left.");
            }

            Room room = student.getCurrentRoom();
            Room roomTo = game.getMap().getRoomList().get(Integer.parseInt(args[1]));

            if (roomTo.isMaxCapacity()) {
                throw new IllegalStateException("The room is full.");
            }

            if (!room.isNeighbour(roomTo)) {
                throw new IllegalStateException("The room is not a neighbour.");
            }

            Menu.getGame().getMap().move(student, roomTo);
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
