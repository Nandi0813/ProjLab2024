package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;
import com.bucikft.Utils.GenerateUtil;
import com.bucikft.Utils.IDmaker;
import com.bucikft.Utils.PathFinder;
import javafx.util.Pair;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.*;

/**
 * Represents the game map.
 */
public class Map implements Serializable {

    private static final Random random = new Random();

    private final List<Room> roomList; // List of rooms in the map
    private final List<Item> itemList; // List of items in the map

    private final int mapSize;

    /**
     * The constructor of the map.
     *
     * @param mapSize    The size of the map.
     * @param students   The list of students.
     * @param professors The list of professors.
     * @param cleaners   The list of cleaners.
     */
    public Map(int mapSize, List<Student> students, List<Professor> professors, List<Cleaner> cleaners){
        this.mapSize = mapSize;
        this.roomList = new ArrayList<>();
        this.itemList = new ArrayList<>();

        // generate doors between rooms
        for (int x = 1; x <= mapSize; x++) {
            for (int y = 1; y <= mapSize; y++) {
                Room room = new Room(x,y);
                roomList.add(room);
            }
        }

        // generate doors between rooms
        for (Room room : roomList) {
            int x = room.getX();
            int y = room.getY();

            if (x == 1) {
                if (y != 1) {
                    GenerateUtil.generateDoor(room, findRoom(x+1,y), DoorLocation.RIGHT);
                }
                if (y != mapSize) {
                    GenerateUtil.generateDoor(room, findRoom(x,y+1), DoorLocation.BOTTOM);
                }
            }
            if (y == 1) {
                if (x != mapSize) {
                    GenerateUtil.generateDoor(room, findRoom(x + 1,y), DoorLocation.RIGHT);
                }
                if (x != 1) {
                    GenerateUtil.generateDoor(room, findRoom(x,y + 1), DoorLocation.BOTTOM);
                }
            }
            if (x > 1 && y > 1) {
                int doorChance = random.nextInt(4);

                if (x != mapSize) {
                    if (y == mapSize || doorChance != 0) {
                        GenerateUtil.generateDoor(room, findRoom(x + 1,y), DoorLocation.RIGHT);
                    }
                }
                if (y != mapSize) {
                    if (x == mapSize || doorChance != 1) {
                        GenerateUtil.generateDoor(room, findRoom(x,y + 1), DoorLocation.BOTTOM);
                    }
                }
            }
        }

        final List<Class<?>> itemClasses = new ArrayList<>(Arrays.asList(AirFreshener.class,DKC.class, Mask.class, SlipStick.class, TVSZ.class, EnergyDrink.class, Hammer.class, HolyCup.class, WetRag.class, Zyn.class, Transistor.class));
        // generate items and put them in rooms
        for (Class<?> itemClass : itemClasses) {
            List<Item> items = GenerateUtil.generateItem(itemClass, mapSize);
            if (items == null) continue;

            itemList.addAll(items);

            for (Item item : items) {
                Room randomRoom;

                do {
                    randomRoom = roomList.get(random.nextInt(roomList.size()));
                } while (randomRoom.isMaxItemCapacity());

                randomRoom.getItemList().add(item);
            }
        }

        // Put the students in random rooms
        for (Student student : students) {
            Room randomRoom;

            do {
                randomRoom = roomList.get(random.nextInt(roomList.size()));
            } while (randomRoom.isMaxPersonCapacity());

            randomRoom.getPersonList().add(student);
            student.setCurrentRoom(randomRoom);
        }

        // Put the professors in random rooms where aren't any students
        for (Professor professor : professors) {
            Room randomRoom;
            if (students.size() + professors.size() + cleaners.size() >= mapSize*mapSize){
                randomRoom = roomList.get(random.nextInt(roomList.size()));
            } else {

                do {
                    randomRoom = roomList.get(random.nextInt(roomList.size()));
                } while (randomRoom.isMaxPersonCapacity() || randomRoom.containsStudent());
            }
            randomRoom.getPersonList().add(professor);
            professor.setCurrentRoom(randomRoom);
        }

        // Put the cleaners in random rooms where aren't any students or professors
        for (Cleaner cleaner : cleaners) {
            Room randomRoom;
            if (students.size() + professors.size() + cleaners.size() >= mapSize*mapSize){
                randomRoom = roomList.get(random.nextInt(roomList.size()));
            } else {
            do {
                randomRoom = roomList.get(random.nextInt(roomList.size()));
            } while (randomRoom.isMaxPersonCapacity() || randomRoom.containsStudent() || randomRoom.containsProfessor());

            }
            randomRoom.getPersonList().add(cleaner);
            cleaner.setCurrentRoom(randomRoom);
        }

        GenerateUtil.generateExit(this);

    }

    /**
     * Generates a list of items.
     *
     * @param x The x coordinate of the room.
     * @param y The y coordinate of the room.
     * @return The list of items.
     */
    public Room findRoom(int x, int y) {
        for (Room room : roomList)
            if (room.getX() == x && room.getY() == y)
                return room;
        return null;
    }

    /**
     * Changes the door to another room.
     * @param room The room where the door is from.
     * @param newRoom The room where the door is to.
     * @param door The door to change.
     */
    private static void setDoorToOtherRoom(Room room, Room newRoom, Door door) {
        room.getDoorList().remove(door);
        newRoom.getDoorList().add(door);

        if (door.getRoomFrom() == room) {
            door.setRoomFrom(newRoom);
        } else {
            door.setRoomTo(newRoom);
        }
    }

    /**
     * Splits a room into two rooms.
     *
     * @param room The room to split.
     */
    public void split(Room room) {
        Room newRoom = new Room(room.getX()+20, room.getY()+20);
        roomList.add(newRoom);
        newRoom.setGassed(room.isGassed());
        newRoom.setSticky(room.isSticky());

        int halfCapacity = room.getPersonCapacity() / 2;
        room.setPersonCapacity(room.getPersonCapacity() - halfCapacity);
        newRoom.setPersonCapacity(halfCapacity);

        int halfItemCapacity = room.getItemCapacity() / 2;
        room.setItemCapacity(room.getItemCapacity() - halfItemCapacity);
        newRoom.setItemCapacity(halfItemCapacity);

        if (room.getItemList().size() > halfItemCapacity) {
            for (int i = halfItemCapacity; i < room.getItemList().size(); i++) {
                newRoom.getItemList().add(room.getItemList().remove(i));
            }
        }

        for (Person p : new ArrayList<>(room.getPersonList())) {
            if (random.nextInt(2) % 2 == 0 && newRoom.getPersonList().size() <= newRoom.getPersonCapacity()) {
                newRoom.getPersonList().add(p);
            } else {
                room.getPersonList().add(p);
            }
        }

        if (random.nextInt(2) % 2 == 0) {
            for (Door door : room.getDoorList()) {
                int doorChance = random.nextInt(2);

                if (door.getLocationFrom() == DoorLocation.RIGHT && door.getRoomFrom() == room || door.getLocationTo() == DoorLocation.LEFT && door.getRoomTo() == room) {
                    setDoorToOtherRoom(room, newRoom, door);
                }
                else if (door.getLocationFrom() == DoorLocation.BOTTOM && door.getRoomFrom() == room  || door.getLocationTo() == DoorLocation.TOP && door.getRoomTo() == room) {
                    if (doorChance == 0) {
                        setDoorToOtherRoom(room, newRoom, door);
                    }
                }
                else if (door.getLocationFrom() == DoorLocation.TOP && door.getRoomFrom() == room  || door.getLocationTo() == DoorLocation.BOTTOM && door.getRoomTo() == room) {
                    if (doorChance == 1) {
                        setDoorToOtherRoom(room, newRoom, door);
                    }
                }
            }

            Door newDoor = new Door(room, newRoom, DoorLocation.RIGHT);
            room.getDoorList().add(newDoor);
            newRoom.getDoorList().add(newDoor);
        }
        else {
            for (Door door : room.getDoorList()) {
                int doorChance = random.nextInt(2);

                if (door.getLocationFrom() == DoorLocation.TOP && door.getRoomFrom() == room || door.getLocationTo() == DoorLocation.BOTTOM && door.getRoomTo() == room) {
                    setDoorToOtherRoom(room, newRoom, door);
                }
                else if (door.getLocationFrom() == DoorLocation.RIGHT && door.getRoomFrom() == room  || door.getLocationTo() == DoorLocation.LEFT && door.getRoomTo() == room) {
                    if (doorChance == 0) {
                        setDoorToOtherRoom(room, newRoom, door);
                    }
                }
                else if (door.getLocationFrom() == DoorLocation.LEFT && door.getRoomFrom() == room  || door.getLocationTo() == DoorLocation.RIGHT && door.getRoomTo() == room) {
                    if (doorChance == 1) {
                        setDoorToOtherRoom(room, newRoom, door);
                    }
                }
            }

            Door newDoor = new Door(room, newRoom, DoorLocation.TOP);
            room.getDoorList().add(newDoor);
            newRoom.getDoorList().add(newDoor);
        }
    }

    /**
     * Merge rooms.
     *
     * @param room        the room
     * @param roomToMerge the room to merge
     */
    public void mergeRooms(Room room, Room roomToMerge){
        room.setItemCapacity(room.getItemCapacity() + roomToMerge.getItemCapacity());
        room.setPersonCapacity(room.getPersonCapacity() + roomToMerge.getPersonCapacity());

        for (Door door : new ArrayList<>(roomToMerge.getDoorList())) {

            if (door.getRoomFrom() == roomToMerge) {
                if(door.getRoomTo() == room){
                    room.getDoorList().remove(door);
                }

                else if(!room.hasDoorAtLocation(door.getLocationFrom())){
                    door.setRoomFrom(room);
                    room.getDoorList().add(door);
                }
            }

            else if (door.getRoomTo() == roomToMerge){
                if(door.getRoomFrom() == room){
                    room.getDoorList().remove(door);
                }

                else if(!room.hasDoorAtLocation(door.getLocationTo())){
                    door.setRoomTo(room);
                    room.getDoorList().add(door);
                }
            }
        }

        for (Item item : new ArrayList<>(roomToMerge.getItemList())) {
            room.getItemList().add(item);
        }
        roomToMerge.getItemList().clear();

        for (Person person : new ArrayList<>(roomToMerge.getPersonList())) {
            room.getPersonList().add(person);
            person.setCurrentRoom(room);
        }
        roomToMerge.getPersonList().clear();

        room.setGassed(room.isGassed() || roomToMerge.isGassed());
        room.setSticky(room.isSticky() || roomToMerge.isSticky());

        for (Room r : new ArrayList<>(roomList)) {
            for (Door d : new ArrayList<>(r.getDoorList())) {
                if (d.getRoomFrom() == roomToMerge) {
                    r.getDoorList().remove(d);
                }
                else if (d.getRoomTo() == roomToMerge) {
                    r.getDoorList().remove(d);
                }
            }
        }

        roomList.remove(roomToMerge);
    }

    /**
     * Retrieves the list of rooms in the map.
     *
     * @return The list of rooms.
     */
    public List<Room> getRoomList() { return this.roomList; }

    /**
     * Retrieves a room by its ID.
     *
     * @param id The ID of the room.
     * @return The room with the given ID.
     */
    public Room getRoom(String id) {
        for (Room room : roomList)
            if (room.getID().equals(id))
                return room;
        return null;
    }

    /**
     * Retrieves the room of the item.
     *
     * @param item The item to get the room of.
     * @return The room of the item.
     */
    public Room getRoom(Item item) {
        for (Room room : roomList)
            if (room.getItemList().contains(item))
                return room;
        return null;
    }

    /**
     * Retrieves the list of items in the map.
     *
     * @return The list of items.
     */
    public List<Item> getItemList() { return this.itemList; }

    /**
     * Gets map size.
     *
     * @return the map size
     */
    public int getMapSize() { return this.mapSize; }

}
