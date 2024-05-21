package com.bucikft.Person;

import com.bucikft.Controllers.TileType;
import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Map;
import com.bucikft.Room;
import com.bucikft.Utils.PathFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Boss professor.
 */
public class BossProfessor extends Professor{

    /**
     * Constructor to initialize a Professor object.
     *
     * @param name the name
     */
    public BossProfessor(String name) {
        super(name);
        type = TileType.BossProfessor;
    }

    /**
     * Merge room.
     *
     * @param map the map
     */
    public void mergeRoom(Map map){
        for(Door d : new ArrayList<>(this.currentRoom.getDoorList())){
            if(d instanceof Exit){
                continue;
            }
            if(d.getRoomTo() == this.currentRoom){
                if(d.getRoomFrom().containsStudent()){
                    map.mergeRooms(this.currentRoom, d.getRoomFrom());
                    return;
                }
            }
            else if(d.getRoomFrom() == this.currentRoom){
                if(d.getRoomTo().containsStudent()){
                    map.mergeRooms(this.currentRoom, d.getRoomTo());
                    return;
                }
            }
        }




    }

}
