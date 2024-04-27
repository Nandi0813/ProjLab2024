package com.bucikft.commands;
import com.bucikft.Door.Door;
import com.bucikft.Game;
import com.bucikft.Person.Student;
import com.bucikft.Room;

public class Move implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("invalid number of arguments");
        try {
            Student student = (Student) game.getFocusedPerson();
            Room room = student.getCurrentRoom();
            int roomnumber = Integer.parseInt(args[1]);
            Room roomto = game.getMap().getRoomList().get(roomnumber);
            if(student.getMovesLeft() > 0){
                if (roomto.getPersonList().size() + 1 <= roomto.getCapacity()) {
                    for (Door d : room.getDoorList()) {
                        if (roomto == d.getRoomTo() || roomto == d.getRoomFrom()) {
                            student.setCurrentRoom(roomto);
                            room.getPersonList().remove(student);
                            roomto.getPersonList().add(student);
                            student.setMovesLeft(student.getMovesLeft() - 1);
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
