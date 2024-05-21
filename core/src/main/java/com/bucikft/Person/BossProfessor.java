package com.bucikft.Person;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Map;
import com.bucikft.Room;
import com.bucikft.Utils.PathFinder;

import java.util.List;

public class BossProfessor extends Professor{

    /**
     * Constructor to initialize a Professor object.
     *
     * @param name
     */
    public BossProfessor(String name) {
        super(name);
    }
    
    public void mergeRoom(Map map, Room room){
        for(Door d : this.currentRoom.getDoorList()){
            if(d.getRoomTo() == this.currentRoom && room == d.getRoomFrom()){
                map.mergeRooms(this.currentRoom, room);
            }
            else if(d.getRoomFrom() == this.currentRoom && room == d.getRoomTo()){
                map.mergeRooms(this.currentRoom, room);
            }
        }




    }

}
