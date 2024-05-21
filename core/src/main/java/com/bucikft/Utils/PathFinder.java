package com.bucikft.Utils;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
import com.bucikft.Room;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathFinder
{

    /**
     *
     * @param room
     * @return
     */
    public static int findShortestPathToStudent(Room room){
        Queue<Room> queue = new LinkedList<>();
        Set<Room> visited = new HashSet<>();
        queue.add(room);
        visited.add(room);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Room currentRoom = queue.poll();
                for (Door door : currentRoom.getDoorList()) {
                    Room nextRoom;
                    if (door.getRoomTo() == currentRoom){
                        nextRoom = door.getRoomFrom();
                    }
                    else{
                        nextRoom = door.getRoomTo();
                    }
                    if (!visited.contains(nextRoom)) {
                        if (nextRoom.containsStudent()) {
                            return count;
                        }
                        queue.add(nextRoom);
                        visited.add(nextRoom);
                    }
                }
            }
            count++;
        }
        return count;
    }

    /**
     *
     * @param room
     * @param longestPath
     * @return
     */
    public static Pair<Integer, Room> updateLongestPathIfNeeded(Room room, int longestPath) {
        int pathLength = findShortestPathToStudent(room);
        if (longestPath < pathLength) {
            longestPath = pathLength;
            return new Pair<>(longestPath,room);
        }
        return null;
    }

    /**
     *
     * @param room
     * @return
     */
    public static LinkedList<DoorLocation> findShortestPathToExit(Room room) {
        Queue<Pair<Room, LinkedList<DoorLocation>>> queue = new LinkedList<>();
        Set<Room> visited = new HashSet<>();
        queue.add(new Pair<>(room, new LinkedList<>()));
        visited.add(room);

        while (!queue.isEmpty()) {
            Pair<Room, LinkedList<DoorLocation>> currentPair = queue.poll();
            Room currentRoom = currentPair.getKey();
            LinkedList<DoorLocation> currentPath = currentPair.getValue();

            for (Door door : currentRoom.getDoorList()) {
                Room nextRoom;
                if (door.getRoomTo() == currentRoom){
                    nextRoom = door.getRoomFrom();
                }
                else{
                    nextRoom = door.getRoomTo();
                }
                if (!visited.contains(nextRoom)) {
                    LinkedList<DoorLocation> nextPath = new LinkedList<>(currentPath);
                    if (door.getRoomTo() == currentRoom){
                        nextPath.add(door.getLocationTo());
                    }
                    else{
                        nextPath.add(door.getLocationFrom());
                    }
                    if (door instanceof Exit) {
                        return nextPath;
                    }
                    queue.add(new Pair<>(nextRoom, nextPath));
                    visited.add(nextRoom);
                }
            }
        }
        return null; // No exit found
    }

    public static Room findShortestRoomToStudent(Room room){
        Queue<Room> queue = new LinkedList<>();
        Set<Room> visited = new HashSet<>();
        queue.add(room);
        visited.add(room);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Room currentRoom = queue.poll();
                for (Door door : currentRoom.getDoorList()) {
                    Room nextRoom;
                    if (door.getRoomTo() == currentRoom){
                        nextRoom = door.getRoomFrom();
                    }
                    else{
                        nextRoom = door.getRoomTo();
                    }
                    if (!visited.contains(nextRoom)) {
                        if (nextRoom.containsStudent()) {
                            return nextRoom;
                        }
                        queue.add(nextRoom);
                        visited.add(nextRoom);
                    }
                }
            }
        }
        return null;
    }

}
