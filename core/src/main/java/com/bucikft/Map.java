package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Items.*;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Cleaner;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Represents the game map.
 */
public class Map {

    private static final Random random = new Random();

    private final List<Room> roomList; // List of rooms in the map
    private final List<Item> itemList; // List of items in the map


    /**
     *
     * @param mapSize
     * @param students
     * @param professors
     * @param cleaners
     * @param idMaker
     */
    public Map(int mapSize, List<Student> students, List<Professor> professors, List<Cleaner> cleaners, IDmaker idMaker){
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
                    generateDoor(room, findRoom(x+1,y), DoorLocation.RIGHT);
                }
                if (y != mapSize) {
                    generateDoor(room, findRoom(x,y+1), DoorLocation.BOTTOM);
                }
            }
            if (y == 1) {
                if (x != mapSize) {
                    generateDoor(room, findRoom(x + 1,y), DoorLocation.RIGHT);
                }
                if (x != 1) {
                    generateDoor(room, findRoom(x,y + 1), DoorLocation.BOTTOM);
                }
            }
            if (x > 1 && y > 1) {
                int doorChance = random.nextInt(4);

                if (x != mapSize) {
                    if (y == mapSize || doorChance != 0) {
                        generateDoor(room, findRoom(x + 1,y), DoorLocation.RIGHT);
                    }
                }
                if (y != mapSize) {
                    if (x == mapSize || doorChance != 1) {
                        generateDoor(room, findRoom(x,y + 1), DoorLocation.BOTTOM);
                    }
                }
            }
        }

        List<Class<?>> itemClasses = new ArrayList<>(Arrays.asList(AirFreshener.class,DKC.class, Mask.class, SlipStick.class, TVSZ.class, EnergyDrink.class, Hammer.class, HolyCup.class, WetRag.class, Zyn.class, Transistor.class));
        // generate items and put them in rooms
        for (Class<?> itemClass : itemClasses) {
            List<Item> items = generateItem(itemClass, mapSize, idMaker);
            itemList.addAll(items);
            for (Item item : items) {
                // todo test for capacity of room
                int randomRoomIndex = (int) (Math.random() * roomList.size());
                Room randomRoom = roomList.get(randomRoomIndex);
                randomRoom.getItemList().add(item);
            }
        }



        // put students in rooms
        for (Student student : students) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(student);
            student.setCurrentRoom(randomRoom);
        }
        // put professors in rooms
        for (Professor professor : professors) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(professor);
        }
        // put cleaners in rooms
        for (Cleaner cleaner : cleaners) {
            int randomRoomIndex = (int) (Math.random() * roomList.size());
            Room randomRoom = roomList.get(randomRoomIndex);
            randomRoom.getPersonList().add(cleaner);
        }
    }

    /**
     *
     * @param itemClass
     * @param mapSize
     * @param idMaker
     * @return
     * @param <T>
     */
    private static <T> List<Item> generateItem(Class<T> itemClass, int mapSize, IDmaker idMaker) {
        int itemCount = (int)( Math.random() * (mapSize/3)+1);
        List<Item> items = new ArrayList<>();
        try {
            // Get the constructor of the specified class with the appropriate parameter types

            Constructor<T> constructor = itemClass.getDeclaredConstructor(String.class, boolean.class);
            boolean falseItem = false;
            if (itemClass.equals(TVSZ.class) || itemClass.equals(SlipStick.class) || itemClass.equals(Mask.class)) {
                if (itemCount>1) {
                    falseItem = true;
                }
            }
            if (itemClass.equals(Transistor.class)) itemCount*=2;
            for (int i = 0; i < itemCount; i++) {
                // Create a new instance of the specified class using the constructor and provided arguments
                T newItem = constructor.newInstance(idMaker.makeID(), i == 0 && falseItem);
                // You can initialize any properties or perform additional setup here
                items.add((Item)newItem);
            }
            return items;

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());// Handle the exception appropriately
            return null; // Or some default value indicating failure
        }

    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private Room findRoom(int x, int y) {
        for (Room room : roomList) {
            if (room.getX() == x && room.getY() == y) {
                return room;
            }
        }
        return null;
    }

    /**
     *
     * @param roomFrom
     * @param roomTo
     * @param location
     */
    private static void generateDoor(Room roomFrom, Room roomTo, DoorLocation location) {
        Door door = new Door(roomFrom, roomTo, location);
        roomFrom.getDoorList().add(door);
        roomTo.getDoorList().add(door);
    }


    /**
     * Moves the person to a certain room.
     *
     * @param person The person who moves.
     * @param roomTo The room where he moves to.
     */
    public void move(Person person, Room roomTo)
    {
        if (roomTo == null)
            throw new IllegalStateException("No roomTo parameter.");

        person.setCurrentRoom(roomTo);

        Room currentRoom = person.getCurrentRoom();
        currentRoom.getPersonList().remove(person);

        roomTo.getPersonList().add(person);

        if (!person.isGodMode() && person.getMovesLeft() <= 1 )
            person.setMovesLeft(person.getMovesLeft() - 1);

        roomTo.setVisitorsSinceLastCleaning(roomTo.getVisitorsSinceLastCleaning() + 1);
        if (roomTo.getVisitorsSinceLastCleaning() >= Room.STICKY_AT)
            roomTo.setSticky(true);
    }

    /**
     *
     * @param room
     * @param newRoom
     * @param door
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

        int halfCapacity = room.getCapacity() / 2;
        room.setCapacity(room.getCapacity() - halfCapacity);
        newRoom.setCapacity(halfCapacity);

        int halfItemCapacity = room.getItemCapacity() / 2;
        room.setItemCapacity(room.getItemCapacity() - halfItemCapacity);
        newRoom.setItemCapacity(halfItemCapacity);

        if (room.getItemList().size() > halfItemCapacity) {
            for (int i = halfItemCapacity; i < room.getItemList().size(); i++) {
                newRoom.getItemList().add(room.getItemList().remove(i));
            }
        }

        for (Person p : new ArrayList<>(room.getPersonList())) {
            if (random.nextInt(2) % 2 == 0 && newRoom.getPersonList().size() <= newRoom.getCapacity()) {
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
     * Finds a path in the map.
     *
     * @return The list of rooms representing the path.
     */
    public List<Room> pathFinding(){
        return roomList; // Temporary return value
    }

    /**
     * Retrieves the list of rooms in the map.
     *
     * @return The list of rooms.
     */
    public List<Room> getRoomList() { return this.roomList; }

    /**
     * Retrieves a room by its ID.
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
     *
     * @param item
     * @return
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
}
