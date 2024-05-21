package com.bucikft.Utils;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Items.Mask;
import com.bucikft.Items.SlipStick;
import com.bucikft.Items.TVSZ;
import com.bucikft.Items.Transistor;
import com.bucikft.Map;
import com.bucikft.Room;
import javafx.util.Pair;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Generate util.
 */
public class GenerateUtil
{

    /**
     * Generates a list of items.
     *
     * @param <T>       The type of the item.
     * @param itemClass The class of the item.
     * @param mapSize   The size of the map.
     * @return The list of items.
     */
    public static <T> List<Item> generateItem(Class<T> itemClass, int mapSize) {
        int itemCount = (int) (Math.random() * (mapSize / 3) + 1);
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

            if (itemClass.equals(Transistor.class)) {
                itemCount *= 2;
            }

            for (int i = 0; i < itemCount; i++) {
                // Create a new instance of the specified class using the constructor and provided arguments
                T newItem = constructor.newInstance(itemClass.getSimpleName() + "#" + IDmaker.makeID(), i == 0 && falseItem);
                // You can initialize any properties or perform additional setup here
                items.add((Item) newItem);
            }

            return items;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());// Handle the exception appropriately
            return null; // Or some default value indicating failure
        }
    }

    /**
     * Generates a list of items.
     *
     * @param roomFrom The room where the door is from.
     * @param roomTo   The room where the door is to.
     * @param location The location of the door.
     */
    public static void generateDoor(Room roomFrom, Room roomTo, DoorLocation location) {
        Door door = new Door(roomFrom, roomTo, location);
        roomFrom.getDoorList().add(door);
        roomTo.getDoorList().add(door);
    }

    /**
     * Generate exit.
     *
     * @param map the map
     */
    public static void generateExit(Map map){
        int longestPath = 0;
        int mapSize = map.getMapSize();
        Room furthestRoom = null;

        for (int i = 1; i <= map.getMapSize(); i++) {
            Room room;

            room = map.findRoom(i, 1);
            Pair<Integer, Room> result = PathFinder.updateLongestPathIfNeeded(room, longestPath);
            if (result != null) {
                longestPath = result.getKey();
                furthestRoom = result.getValue();
            }

            room = map.findRoom(1, i);
            result = PathFinder.updateLongestPathIfNeeded(room, longestPath);
            if (result != null) {
                longestPath = result.getKey();
                furthestRoom = result.getValue();
            }

            room = map.findRoom(mapSize, i);
            result = PathFinder.updateLongestPathIfNeeded(room, longestPath);
            if (result != null) {
                longestPath = result.getKey();
                furthestRoom = result.getValue();
            }

            room = map.findRoom(i, mapSize);
            result = PathFinder.updateLongestPathIfNeeded(room, longestPath);
            if (result != null) {
                longestPath = result.getKey();
                furthestRoom = result.getValue();
            }
        }

        if (furthestRoom != null){
            Exit exit = new Exit(furthestRoom, null, furthestRoom.emptyDoor());
            furthestRoom.getDoorList().add(exit);
        }
    }

}
