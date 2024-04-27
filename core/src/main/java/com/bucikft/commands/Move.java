package com.bucikft.commands;
import com.bucikft.Door.Door;
import com.bucikft.Game;
import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;

public class Move implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("invalid number of arguments");

        try {
            Student student = (Student) game.getFocusedPerson();
            Room room = student.getCurrentRoom();
            Room roomTo = game.getMap().getRoomList().get(Integer.parseInt(args[1]));

            if (student.getMovesLeft() > 0){
                if (roomTo.getPersonList().size() + 1 <= roomTo.getCapacity()) {
                    for (Door d : room.getDoorList()) {
                        if (roomTo == d.getRoomTo() || roomTo == d.getRoomFrom()) {
                            Menu.getGame().getMap().move(student, roomTo);
                        } else {
                            System.out.println("Door is not a pointing to a neighbouring room.");
                        }
                    }

                }
            }
            else{
                System.out.println("No moves left.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("invalid direction");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
