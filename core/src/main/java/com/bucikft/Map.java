package com.bucikft;
import com.bucikft.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Room> roomList;
    private List<Item> itemList;

    public Map(){
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }

    /*
     * A függvény egy szobát két szobára bont fel.
     * @param room A bontandó szoba
     */
    public void split(Room room) {

    }

    public List<Room> pathFinding(){
        return roomList; //ideiglenes visszateresi ertek
    }

    public List<Room> getRoomList() { return this.roomList; }
    public List<Item> getItemList() { return this.itemList; }

}