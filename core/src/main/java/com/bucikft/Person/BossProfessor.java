package com.bucikft.Person;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
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
    
    public void mergeRoom(Map map){
        for(Door d : this.currentRoom.getDoorList()){
            if(d instanceof Exit){
                continue;
            }
            if(d.getRoomTo() == this.currentRoom){
                for(Person p : d.getRoomFrom().getPersonList()){
                    if(p instanceof Student){
                        map.mergeRooms(this.currentRoom, d.getRoomFrom());
                    }
                }
            }
            else if(d.getRoomFrom() == this.currentRoom){
                for(Person p : d.getRoomTo().getPersonList()){
                    if(p instanceof Student){
                        map.mergeRooms(this.currentRoom, d.getRoomTo());
                    }
                }
            }
        }




    }

}
